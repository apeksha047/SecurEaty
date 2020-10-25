package com.example.secureaty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button Scanbtn, pController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Scanbtn =  findViewById(R.id.Scanbutton);
        pController = findViewById(R.id.permission_controller_btn);

        Scanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseFileActivity();
            }
        });

        pController.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pControllerActivity();
            }
        });
    }


    public void ChooseFileActivity(){
        Intent intent_chooseFileActivity= new Intent(this,ChooseFileActivity.class);
        startActivity(intent_chooseFileActivity);
    }

    public void pControllerActivity(){
        Intent intent_pControllerActivity= new Intent(this,pControllerActivity.class);
        startActivity(intent_pControllerActivity);
    }
}

