package com.mcc.selectedrecycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SelectedAdapter extends RecyclerView.Adapter<SelectedAdapter.ViewHolder> {

    private Context mContext;
    private OnItemSelectedListener mListener;
    private List<ItemModel> dataList;

    public SelectedAdapter(List<ItemModel> dataList, Context mContext) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
        return new SelectedAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        manageItemSelection(viewHolder, i);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
    private void manageItemSelection(ViewHolder holder, int position) {
        boolean selected = dataList.get(position).isCategorySelected();
        if (selected) {
            Glide.with(mContext).load(dataList.get(position).getSelected()).into(holder.imageView);
            holder.textView.setText(dataList.get(position).name);
        } else {

            Glide.with(mContext).load(dataList.get(position).getNonSelected()).into(holder.imageView);
            holder.textView.setText(dataList.get(position).name);
        }
    }

    public void setItemClickListener(OnItemSelectedListener mListener) {
        this.mListener = mListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView;
        ViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_logo);
            textView=itemView.findViewById(R.id.tv_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                itemView.setSelected(true);
                mListener.onItemSelect(getLayoutPosition());
            }
        }
    }
}
