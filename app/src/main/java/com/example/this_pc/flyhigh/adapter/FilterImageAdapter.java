package com.example.this_pc.flyhigh.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.this_pc.flyhigh.R;
import com.example.this_pc.flyhigh.pojo.Detail_imageFilter;

import java.util.List;

public class FilterImageAdapter extends RecyclerView.Adapter<FilterImageAdapter.FilterViewHolder>{

    List<Detail_imageFilter> details;
    Context context;

    public FilterImageAdapter (List<Detail_imageFilter> details){this.details=details;}

    @NonNull
    @Override
    public FilterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_image_layout,parent,false);
        return new FilterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterViewHolder holder, int position) {
        Glide.with(context)
                .load(details.get(position).getImage())
                .into(holder.filtered_img);
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public class FilterViewHolder extends RecyclerView.ViewHolder{
        ImageView filtered_img;
        public FilterViewHolder(View itemView) {
            super(itemView);
            filtered_img = (ImageView) itemView.findViewById(R.id.filtered_img);
        }
    }
}
