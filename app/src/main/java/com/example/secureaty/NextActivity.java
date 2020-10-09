package com.example.secureaty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
    private TextView txt_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        txt_view = (TextView) findViewById(R.id.text_view);

        for (int i = 0; i < CustomAdapter.listIViewItemsArrayList.size(); i++){
            if(CustomAdapter.listIViewItemsArrayList.get(i).getSelected()) {
                txt_view.setText(txt_view.getText() + "\n" + CustomAdapter.listIViewItemsArrayList.get(i).getFile());
            }
        }
    }
}