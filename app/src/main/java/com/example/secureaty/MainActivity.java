package com.example.secureaty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {
    Button Scanbtn,KarmaDetectorBtn, permissionControllerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Scanbtn = (Button) findViewById(R.id.Scanbutton);
        KarmaDetectorBtn = findViewById(R.id.karma_detector_btn);
        permissionControllerBtn = (Button) findViewById(R.id.permissionControllerBtn);

        Scanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseFileActivity();
            }
        });

        KarmaDetectorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KarmaAttackDetector();
            }
        });

        permissionControllerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAllActivityInstalledIntent();
            }
        });

    }

    public void KarmaAttackDetector(){
        Intent intent_karmaAttackDetector=new Intent(this,KarmaAttackDetector.class);
        startActivity(intent_karmaAttackDetector);
    }

    private void openAllActivityInstalledIntent(){
        Intent allInstalledActivityIntent = new Intent(MainActivity.this, AllInstalledAppsActivity.class);
        startActivity(allInstalledActivityIntent);
    }

    public void ChooseFileActivity() {
//        Intent intent_chooseFileActivity= new Intent(this,ChooseFileActivity.class);
//        startActivity(intent_chooseFileActivity);
        Intent intent_chooseFileActivity = new Intent(this, ChooseFileActivity.class);
        intent_chooseFileActivity.putExtra("EXTRA_SESSION_ID", "0");
        startActivity(intent_chooseFileActivity);
    }

    public void check(View view) {
        Intent intent_chooseFileActivity = new Intent(this, ChooseFileActivity.class);
        intent_chooseFileActivity.putExtra("EXTRA_SESSION_ID", "1");
        startActivity(intent_chooseFileActivity);
    }
}

