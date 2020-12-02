package com.example.secureaty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NextActivity extends AppCompatActivity {
    public int progress = 0;
    public PackageManager pm;
//    public
//    public ProgressBar pbHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Log.d("Next activity", "Loaded");
       //pbHorizontal = (ProgressBar) findViewById(R.id.pb_horizontal);
        LinearLayout parentLayout = (LinearLayout) findViewById(R.id.parentLayout);
        pm = getPackageManager();

//        for (ListViewItem item : PackageListAdapter.viewItems) {
//            if(item.getSelected()) {
//                TextView textView = new TextView(NextActivity.this);
//                textView.setText(item.getPackageName());
//                parentLayout.addView(textView);
//                // add progress bar view
//
//                Log.d("started Execution:", "started");
//
//            }
//        }

//        List<File> files = getPackageFiles();
//        for(File f: files) {
//          decompileFile(f);
//        }

        for (PackageInfo p : ChooseFileActivity.selectedPackages) {

            TextView textView = new TextView(NextActivity.this);
            textView.setText(pm.getApplicationLabel(p.applicationInfo).toString());
            parentLayout.addView(textView);
            // add progress bar view
            ProgressBar progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(30, 30, 30, 30);
            progressBar.setLayoutParams(layoutParams);
            parentLayout.addView(progressBar);

            Log.d("started Execution:", "started");
            decompileFile(new File(p.applicationInfo.sourceDir), progressBar);
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

    public void decompileFile(File file, ProgressBar pb){
            DecompileAction action = new DecompileAction();
            action.setProgressBar(pb);
            action.execute(file);
    }


}