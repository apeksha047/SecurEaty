package com.example.secureaty;

import android.app.DownloadManager;
import android.os.AsyncTask;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecompileAction extends AsyncTask<File, Void, String> {
    private Exception exception;
    private String decompileUrl = "http://app.apkdecompilers.com/app.php";
    private Pattern decompiledZipPattern = Pattern.compile("https:\\/\\/app.apkdecompilers.com\\/download\\/.*\\.apk\\.zip");

    protected String doInBackground(File... files) {
        Log.d("Decompile file", files[0].getName());
        try {
            MultipartUtility multipart = new MultipartUtility(decompileUrl, "UTF-8");
            multipart.addFilePart("apk", files[0]);
            String response = multipart.finish(); // response from server.
            Matcher m = decompiledZipPattern.matcher(response);
            m.find();
            String downloadUrl = m.group();
            Log.d("Decompile file success", downloadUrl);
            Log.d("Decompile file download", downloadUrl);
            InputStream input = null;
            OutputStream output = null;
            HttpURLConnection connection = null;
            URL url = new URL(downloadUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            // expect HTTP 200 OK, so we don't mistakenly save error report
            // instead of the file
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                return "Server returned HTTP " + connection.getResponseCode()
                        + " " + connection.getResponseMessage();
            }

            // this will be useful to display download percentage
            // might be -1: server did not report the length
            int fileLength = connection.getContentLength();

            // download the file
            input = connection.getInputStream();
            output = new FileOutputStream("/sdcard/file_name.extension");

            byte data[] = new byte[4096];
            long total = 0;
            int count;
            while ((count = input.read(data)) != -1) {
                // allow canceling with back button
                if (isCancelled()) {
                    input.close();
                    return null;
                }
                total += count;
                output.write(data, 0, count);
            }
            Log.d("Decompile file download", "Success: " + downloadUrl);
            return downloadUrl;
        } catch (Exception e) {
            this.exception = e;
            Log.d("Decompile file failed", files[0].getName());
            Log.d("Decompile file failed", e.toString());
        } finally {
            return null;
        }
    }

    protected void onPostExecute(String result) {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}