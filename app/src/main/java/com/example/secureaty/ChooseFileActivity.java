package com.example.secureaty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
import java.lang.Override;

public class ChooseFileActivity extends AppCompatActivity {
   // MyCustomAdapter customAdapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_file);

        displayListView();
    }

    public void displayListView(){
        ArrayList<ListViewItems> fileList = new ArrayList<ListViewItems>();

        ListViewItems items= new ListViewItems("file1",false);
        fileList.add(items);
        items= new ListViewItems("file2",false);
        fileList.add(items);
        items= new ListViewItems("file3",false);
        fileList.add(items);
        items= new ListViewItems("file4",false);
        fileList.add(items);
        items= new ListViewItems("file5",false);
        fileList.add(items);
        items= new ListViewItems("file6",false);
        fileList.add(items);
        items= new ListViewItems("file7",false);
        fileList.add(items);
        items= new ListViewItems("file8",false);
        fileList.add(items);
        items= new ListViewItems("file9",false);
        fileList.add(items);
        items= new ListViewItems("file10",false);
        fileList.add(items);

        //create arrayadapter from string array
        /*customAdapter=new MyCustomAdapter(this, R.layout.activity_choose_file);
        ListView listView=(ListView) findViewById(R.id.list_view);

        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListViewItems viewItems=(ListViewItems) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),"Clicked -- "+ viewItems.getName(),Toast.LENGTH_LONG).show();

            }
        });*/
    }

    public class MyCustomerAdapter extends ArrayAdapter<ListViewItems>{
        private ArrayList<ListViewItems> fileList;

            public MyCustomerAdapter(Context context, int textviewResouceid, ArrayList<ListViewItems> fileList){
                super(context,textviewResouceid,fileList);
                this.fileList=new ArrayList<ListViewItems>();
                this.fileList.addAll(fileList);

            }


    }

    private class ViewHolder{
        TextView code;
        CheckBox name;
    }
/*
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position,convertView,parent);

        ViewHolder holder = null;
        Log.v("ConvertView", String.valueOf(position));

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.text_plus_checkbox, null);

            holder = new ViewHolder();
            holder.code = (TextView) convertView.findViewById(R.id.code);
            holder.name = (CheckBox) convertView.findViewById(R.id.checkbox1);

            convertView.setTag(holder);

            holder.name.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v ;
                    ListViewItems items = (ListViewItems) cb.getTag();
                    Toast.makeText(getApplicationContext(),"Clicked on Checkbox: "+ cb.getText() +" is "+ cb.isChecked(),Toast.LENGTH_LONG).show();
                    items.setSelected(cb.isChecked());
                }
            });
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        ListViewItems items = fileList.get(position);
        holder.code.setText(" (" +  items.getCode() + ")");
        holder.name.setText(items.getName());
        holder.name.setChecked(items.getSelected());
        holder.name.setTag(items);

        return convertView;
    }

    private void checkButtonClick() {


        Button myButton = (Button) findViewById(R.id.findSelected);
        myButton*/
}

