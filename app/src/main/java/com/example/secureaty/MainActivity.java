package com.example.secureaty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button Scanbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

