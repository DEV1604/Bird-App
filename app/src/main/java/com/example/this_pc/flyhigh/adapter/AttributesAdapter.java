package com.example.this_pc.flyhigh.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.this_pc.flyhigh.pojo.Detail_imageFilter;

import java.util.List;

public class AttributesAdapter extends RecyclerView.Adapter<AttributesAdapter.AttributesViewHolder> {

    List<Detail_imageFilter> all_attributes;

    public AttributesAdapter(List<Detail_imageFilter> all_attributes) {this.all_attributes=all_attributes;
    }

    @NonNull
    @Override
    public AttributesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AttributesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return all_attributes.size();
    }

    public class AttributesViewHolder extends RecyclerView.ViewHolder{
        public AttributesViewHolder(View itemView) {
            super(itemView);


        }
    }
}
