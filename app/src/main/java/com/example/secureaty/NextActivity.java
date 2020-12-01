package com.example.secureaty;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NextActivity extends AppCompatActivity {
    private TextView txt_view;
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Log.d("Next activity", "Loaded");

        txt_view = findViewById(R.id.text_view);
        progressBar = findViewById(R.id.progress_bar);

        for (ListViewItem item : PackageListAdapter.viewItems) {
            if(item.getSelected()) {
                txt_view.setText(txt_view.getText() + "\n" + item.getPackageName());
                //add progressbar view
                progressBar.setProgress(0);
                progressBar.setTag("Scanning..");//just check the sites "sec"-bookmark saved for reference
            }
        }

        List<File> files = getPackageFiles();
        for(File f: files) {
            decompileFile(f);
        }
    }

//      ----extract files (for future processing)----
        public List<File> getPackageFiles() {
            List<File> files = new ArrayList<>();
            for (PackageInfo p : ChooseFileActivity.selectedPackages) {
                files.add(new File(p.applicationInfo.sourceDir));
            }
            Log.d("files", "" + files);

            return files;
        }

    public void decompileFile(File file){
            new DecompileAction().execute(file);
    }


}