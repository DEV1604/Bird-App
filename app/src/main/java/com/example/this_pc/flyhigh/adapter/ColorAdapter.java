package com.example.this_pc.flyhigh.adapter;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.this_pc.flyhigh.R;

import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewHolder> {

    List<Palette.Swatch> swatches;

    public ColorAdapter(List<Palette.Swatch> swatches) {
        this.swatches = swatches;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_color_layout, parent, false);
        return new ColorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        if(swatches.get(position) != null){
            holder.color_holder.setBackgroundColor(swatches.get(position).getRgb());
            holder.color_holder_1.setBackgroundColor(swatches.get(position).getRgb());
        }
    }

    @Override
    public int getItemCount() {
        return swatches.size();
    }


    public class ColorViewHolder extends RecyclerView.ViewHolder {
        ImageView color_holder;
        ImageView color_holder_1;
        RelativeLayout color_head;
        RelativeLayout color_head_1;

        public ColorViewHolder(View itemView) {
            super(itemView);
            color_holder = (ImageView) itemView.findViewById(R.id.color_holder);
            color_head = (RelativeLayout) itemView.findViewById(R.id.color_head);
            color_head_1 = (RelativeLayout) itemView.findViewById(R.id.color_head_1);
            color_holder_1 = (ImageView) itemView.findViewById(R.id.color_holder_1);

            color_holder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    color_head.setVisibility(View.GONE);
                    color_head_1.setVisibility(View.VISIBLE);
                    int i = getAdapterPosition();
                }
            });

            color_holder_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    color_head.setVisibility(View.VISIBLE);
                    color_head_1.setVisibility(View.GONE);
                }
            });

        }
    }
}
