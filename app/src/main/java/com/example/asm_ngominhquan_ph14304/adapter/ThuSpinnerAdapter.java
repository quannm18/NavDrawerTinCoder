package com.example.asm_ngominhquan_ph14304.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asm_ngominhquan_ph14304.R;
import com.example.asm_ngominhquan_ph14304.entity.Thu;

import java.util.List;

public class ThuSpinnerAdapter extends BaseAdapter {
    private List<Thu> mList;
    private LayoutInflater mLayoutInflater;

    public ThuSpinnerAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setList(List<Thu> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mList==null)
            return 0;
        return mList.size();
    }

    @Override
    public Thu getItem(int position) {
        if (mList == null)
            return null;
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        KhoanThuViewHolder holder = new KhoanThuViewHolder(convertView);
        if (convertView==null){
            convertView = mLayoutInflater.inflate(R.layout.spinner_thu_item,null,false);
            holder = new KhoanThuViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (KhoanThuViewHolder) convertView.getTag();
        }
        holder.tvName.setText(mList.get(position).ten);
        return convertView;
    }
    public static class  KhoanThuViewHolder{
        public TextView tvName;
        public KhoanThuViewHolder(View view){
            tvName = view.findViewById(R.id.tvNameSP);
        }
    }
}
