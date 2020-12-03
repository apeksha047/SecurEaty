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
    Button Scanbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        try {
//            Scanner scanner = new Scanner(new File("/data/user/0/com.example.secureaty/cache/cloak.txt"));
//            StringBuilder result = new StringBuilder();
//            result.append(scanner.useDelimiter("\0").next());
//            scanner.close();
//            boolean OverlayDetected = OverlayDetector.detect(result.toString());
//            Log.d("overlaydetected", String.valueOf(OverlayDetected));
//
//        } catch (IOException e){}
        Scanbtn = (Button) findViewById(R.id.Scanbutton);
        Scanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseFileActivity();
            }
        });
    }


    public void ChooseFileActivity(){
        Intent intent_chooseFileActivity= new Intent(this,ChooseFileActivity.class);
        startActivity(intent_chooseFileActivity);
    }
}

