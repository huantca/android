package com.example.listview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    private ArrayList<Contact> data;
    private Activity activity;
    private LayoutInflater inflater;

    public Adapter() {
    }

    public Adapter(ArrayList<Contact> data, Activity activity) {
        this.data = data;
        this.activity = activity;
        this.inflater = (LayoutInflater) activity.getSystemService(
                activity.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return data.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = view;
        if(v==null)
            v = inflater.inflate(R.layout.contactitem,null);
        ImageView imageView = v.findViewById(R.id.imageView);
        TextView tvname = v.findViewById(R.id.tvName);
        tvname.setText(data.get(i).getName());
        TextView tvphone = v.findViewById(R.id.tvName2);
        tvphone.setText(data.get(i).getPhone());
        return  v;
    }

}
