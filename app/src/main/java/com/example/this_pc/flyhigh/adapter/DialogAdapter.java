package com.example.this_pc.flyhigh.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.this_pc.flyhigh.R;
import com.example.this_pc.flyhigh.pojo.DetailFilters;
import com.example.this_pc.flyhigh.utils.Listdetails;

import java.util.List;

public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.DialogViewHolder> {

    List<DetailFilters> sub_details;
    Context context;
    int postion_prev;

    public DialogAdapter(int postion_prev) {
        this.sub_details= Listdetails.detail;
        this.postion_prev=postion_prev;
    }

    @NonNull
    @Override
    public DialogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context=parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_dialog_filter_layout,parent,false);
        return new DialogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DialogViewHolder holder, int position) {
        holder.dialog_btn.setText(sub_details.get(postion_prev).getSubFilter().get(position));
    }

    @Override
    public int getItemCount() {
        return sub_details.size();
    }

    public class DialogViewHolder extends RecyclerView.ViewHolder {

        TextView dialog_btn;
        public DialogViewHolder(View itemView) {
            super(itemView);
            dialog_btn = (TextView) itemView.findViewById(R.id.dialog_btn);
        }
    }
}
