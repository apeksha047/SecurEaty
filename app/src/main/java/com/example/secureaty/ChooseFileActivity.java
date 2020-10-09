package com.example.secureaty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ChooseFileActivity extends AppCompatActivity {
    Button nextBtn,deselectAllBtn,selectAllBtn;
    ArrayList<String> selectedItems=new ArrayList<>();
    private ListView lv;
    private ArrayList<ListIViewItems> listIViewItems;
    private CustomAdapter customAdapter;

    private  String[] fileList = new String[]{"file1", "file2", "file3", "file4", "file5", "file6", "file7", "file8", "file9", "file10", "file11","file12", "file13", "file14", "file15", "file16", "file17"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_file);

        lv = (ListView) findViewById(R.id.lv);
        nextBtn = (Button) findViewById(R.id.btn_next);
        deselectAllBtn = (Button) findViewById(R.id.btn_deselectAll);
        selectAllBtn = (Button) findViewById(R.id.btn_selectAll);

        listIViewItems = getFile(false);
        customAdapter = new CustomAdapter(this,listIViewItems);
        lv.setAdapter(customAdapter);

        selectAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listIViewItems = getFile(true);
                customAdapter = new CustomAdapter(ChooseFileActivity.this,listIViewItems);
                lv.setAdapter(customAdapter);
            }
        });
        deselectAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listIViewItems = getFile(false);
                customAdapter = new CustomAdapter(ChooseFileActivity.this,listIViewItems);
                lv.setAdapter(customAdapter);
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseFileActivity.this,NextActivity.class);
                startActivity(intent);
            }
        });


    }

    private ArrayList<ListIViewItems> getFile(boolean isSelect){
        ArrayList<ListIViewItems> list = new ArrayList<>();
        for(int i = 0; i < 17; i++){

            ListIViewItems items = new ListIViewItems();
            items.setSelected(isSelect);
            items.setFile(fileList[i]);
            list.add(items);
        }
        return list;
    }

}
