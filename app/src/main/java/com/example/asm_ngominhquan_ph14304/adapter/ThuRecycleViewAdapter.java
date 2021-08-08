package com.example.asm_ngominhquan_ph14304.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm_ngominhquan_ph14304.R;
import com.example.asm_ngominhquan_ph14304.entity.Thu;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ThuRecycleViewAdapter extends RecyclerView.Adapter<ThuRecycleViewAdapter.ThuViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<Thu> mList;

    public static ItemClickListener itemEditClickListener;
    public static ItemClickListener itemViewClickListener;

    public ThuRecycleViewAdapter(Context context){
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setOnItemEditClickListener(ItemClickListener itemEditClickListener) {
        ThuRecycleViewAdapter.itemEditClickListener = itemEditClickListener;
    }

    public void setOnItemViewClickListener(ItemClickListener itemViewClickListener) {
        ThuRecycleViewAdapter.itemViewClickListener = itemViewClickListener;
    }

    @NonNull
    @NotNull
    @Override
    public ThuViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.recycleview_thu_item,parent,false);

        return new ThuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ThuViewHolder holder, int position) {
        if (mList != null){
            holder.tvName.setText(mList.get(position).ten);
            holder.tvAmount.setText(""+mList.get(position).sotien+" dong");
            holder.position = position;
        }
    }

    public Thu getItem(int position){
        if (mList==null ||mList.size()<= position){
            return null;
        }
        return mList.get(position);
    }

    @Override
    public int getItemCount() {
        if (mList==null)
            return 0;
        return mList.size();
    }

    public void setList(List<Thu> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    public static class ThuViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName,tvAmount;
        public ImageView imvView;
        public ImageView imvEdit;
        public CardView cardView;
        public int position;
        public ThuViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvAmount =(TextView) itemView.findViewById(R.id.tvAmount);
            imvView = (ImageView) itemView.findViewById(R.id.imvView);
            imvEdit = (ImageView) itemView.findViewById(R.id.imvEdit);
            cardView = (CardView) itemView;
            imvView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemViewClickListener!=null){
                        itemViewClickListener.onItemClick(position);
                    }
                }
            });
            imvEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemEditClickListener!=null){
                        itemEditClickListener.onItemClick(position);
                    }
                }
            });
        }
    }
}
