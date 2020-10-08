package com.example.secureaty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    public  static ArrayList<ListIViewItems> listIViewItemsArrayList;

    public CustomAdapter(Context context, ArrayList<ListIViewItems> listIViewItemsArrayList){
        this.context=context;
        this.listIViewItemsArrayList=listIViewItemsArrayList;
    }

    @Override
    public  int getViewTypeCount(){
        return getCount();
    }

    @Override
    public int getItemViewType(int position){
        return position;
    }

    @Override
    public int getCount(){
        return listIViewItemsArrayList.size();
    }

    @Override
    public Object getItem(int position){
        return listIViewItemsArrayList.get(position);
    }

    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup){
        final ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder(); LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.text_plus_checkbox, null, true);

            holder.checkBox = (CheckBox) convertView.findViewById(R.id.checkbox_plus);
            holder.tvFile = (TextView) convertView.findViewById(R.id.file);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }


       // holder.checkBox.setText("Checkbox "+position);
        holder.tvFile.setText(listIViewItemsArrayList.get(position).getFile());

        holder.checkBox.setChecked(listIViewItemsArrayList.get(position).getSelected());

        holder.checkBox.setTag(R.integer.btnplusview, convertView);
        holder.checkBox.setTag( position);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View tempview = (View) holder.checkBox.getTag(R.integer.btnplusview);
                TextView tv = (TextView) tempview.findViewById(R.id.file);
                Integer pos = (Integer)  holder.checkBox.getTag();
                Toast.makeText(context, "Checkbox "+pos+" clicked!", Toast.LENGTH_SHORT).show();

                if(listIViewItemsArrayList.get(pos).getSelected()){
                    listIViewItemsArrayList.get(pos).setSelected(false);
                }else {
                    listIViewItemsArrayList.get(pos).setSelected(true);
                }

            }
        });

        return convertView;
    }

    private class ViewHolder {

        protected CheckBox checkBox;
        private TextView tvFile;

    }
}
