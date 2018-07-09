package com.example.this_pc.flyhigh.adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.this_pc.flyhigh.R;
import com.example.this_pc.flyhigh.fragments.ModalBottomFilterSheet;
import com.example.this_pc.flyhigh.pojo.DetailFilters;
import com.example.this_pc.flyhigh.utils.C;
import com.example.this_pc.flyhigh.utils.Listdetails;

import java.util.List;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.FilterViewHolder> {

    List<DetailFilters> details;
    Context context;
    FragmentManager frag;
    public FilterAdapter(List<DetailFilters> details, FragmentManager fragment){
        this.frag=fragment;
        this.details=details;
        Listdetails.detail=details;
    }

    @NonNull
    @Override
    public FilterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context=parent.getContext();
        C.context_dialog_adapter=context;
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_filter_layout,parent,false);
        return new FilterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterViewHolder holder, int position) {
        holder.filter_text.setText(details.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public class FilterViewHolder extends RecyclerView.ViewHolder{
        TextView filter_text;
        Dialog dialog;
        TextView dialog_btn;
        RecyclerView recyclerView;
        List<String> sub_filters;
        ModalBottomFilterSheet modalBottomFilterSheet;
        public FilterViewHolder(final View itemView) {
            super(itemView);
            filter_text =(TextView)itemView.findViewById(R.id.filter_btn);
            dialog=new Dialog(context);

            modalBottomFilterSheet = new ModalBottomFilterSheet();

            filter_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    modalBottomFilterSheet.show(frag,"");
                    C.adapterPosition =  Integer.toString(getAdapterPosition());

                }
            });

        }
    }
}
/*Integer.parseInt(C.adapterPosition);*/

                    /*dialog.setContentView(R.layout.dialog_layout);*/

                    /*recyclerView = (RecyclerView)dialog.findViewById(R.id.dialog_box);
                    recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false));
                    recyclerView.setAdapter(new DialogAdapter(getAdapterPosition()));*/

                    /*dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    dialog.show();*/