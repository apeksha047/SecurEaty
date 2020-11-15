package com.example.secureaty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NextActivity extends AppCompatActivity {
    private TextView txt_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Log.d("Next activity", "Loaded");

        txt_view = (TextView) findViewById(R.id.text_view);

        for (ListViewItem item : PackageListAdapter.viewItems) {
            if(item.getSelected()) {
                txt_view.setText(txt_view.getText() + "\n" + item.getPackageName());
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