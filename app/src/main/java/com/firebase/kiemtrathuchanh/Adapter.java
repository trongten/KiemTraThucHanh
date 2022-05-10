package com.firebase.kiemtrathuchanh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {

    private Context context;
    private int idLayout;
    private List<KhoaHoc> listChi;
    private int positionSelect = -1;

    public Adapter(Context context, int idLayout, List<KhoaHoc> listChi) {
        this.context = context;
        this.idLayout = idLayout;
        this.listChi = listChi;
    }

    @Override
    public int getCount() {
        return listChi.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);

        TextView tenct = convertView.findViewById(R.id.textView);
        TextView sotien = convertView.findViewById(R.id.textView2);

        tenct.setText(listChi.get(position).getTen());
        sotien.setText((int) listChi.get(position).getGia());


        return convertView;
    }
}
