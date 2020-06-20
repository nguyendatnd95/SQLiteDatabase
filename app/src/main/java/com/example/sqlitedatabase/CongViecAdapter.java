package com.example.sqlitedatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CongViecAdapter extends BaseAdapter {
    private MainActivity context;
    private int layout;
    private List<CongViec> arrayCongViec;

    public CongViecAdapter(MainActivity context, int layout, List<CongViec> arrayCongViec) {
        this.context = context;
        this.layout = layout;
        this.arrayCongViec = arrayCongViec;
    }

    @Override
    public int getCount() {
        return arrayCongViec.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView tvTen;
        ImageView imgDelete, imgEdit;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            viewHolder = new ViewHolder();
            viewHolder.tvTen       = convertView.findViewById(R.id.textViewTen);
            viewHolder.imgDelete   = convertView.findViewById(R.id.imageViewDelete);
            viewHolder.imgEdit     = convertView.findViewById(R.id.imageViewEdit);
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final CongViec congViec = arrayCongViec.get(position);

        viewHolder.tvTen.setText(congViec.getTenCV());


        //bắt sự kiện xóa & sửa
        viewHolder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogSuaCongViec(congViec.getTenCV(), congViec.getIdCV());

            }
        });

        viewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogXoa(congViec.getTenCV(), congViec.getIdCV());
            }
        });

        return convertView;
    }
}
