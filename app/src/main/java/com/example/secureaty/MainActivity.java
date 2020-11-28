package com.example.secureaty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button Scanbtn,KarmaDetectorBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Scanbtn = findViewById(R.id.Scanbutton);
        KarmaDetectorBtn = findViewById(R.id.karma_detector_btn);

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
    }


    public void ChooseFileActivity(){
        Intent intent_chooseFileActivity= new Intent(this,ChooseFileActivity.class);
        startActivity(intent_chooseFileActivity);
    }

    public void KarmaAttackDetector(){
        Intent intent_karmaAttackDetector=new Intent(this,KarmaAttackDetector.class);
        startActivity(intent_karmaAttackDetector);
    }
}

