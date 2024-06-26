package com.example.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class SinhvienAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Sinhvien> data;

    public SinhvienAdapter(Context context, int layout, ArrayList<Sinhvien> data) {
        this.context = context;
        this.layout = layout;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Sinhvien getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, parent, false);
            holder = new ViewHolder();
            holder.idTextView = convertView.findViewById(R.id.txtId);
            holder.nameTextView = convertView.findViewById(R.id.txtName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Sinhvien sv = data.get(position);
        holder.idTextView.setText(String.valueOf(sv.getId()));
        holder.nameTextView.setText(sv.getName());

        return convertView;
    }

    private static class ViewHolder {
        TextView idTextView;
        TextView nameTextView;
    }
}

