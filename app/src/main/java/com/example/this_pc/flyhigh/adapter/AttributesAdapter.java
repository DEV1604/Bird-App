package com.example.this_pc.flyhigh.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.this_pc.flyhigh.R;
import com.example.this_pc.flyhigh.pojo.Detail_imageFilter;
import com.example.this_pc.flyhigh.utils.Listdetails;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Inflater;

public class AttributesAdapter extends RecyclerView.Adapter<AttributesAdapter.AttributesViewHolder> {

    JSONObject detail;

    List<String> keys = new ArrayList<String>();
    Context context;

    public AttributesAdapter(Detail_imageFilter details) {
        try {
            detail = new JSONObject(new Gson().toJson(details));
            for (Iterator<String> it = detail.keys(); it.hasNext(); ) {
                String e = it.next();
                Log.d("it-next",e.toString());
                if (!e.equals("image"))
                keys.add(e);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    @Override
    public AttributesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_attribute_layout, parent, false);
        return new AttributesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttributesViewHolder holder, int position) {
        holder.attrib_key.setText(keys.get(position));
        try {
            holder.attrib_value.setText(detail.get(keys.get(position)).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return keys.size();
    }

    public class AttributesViewHolder extends RecyclerView.ViewHolder {
        TextView attrib_key, attrib_value;

        public AttributesViewHolder(View itemView) {
            super(itemView);
            attrib_key = (TextView) itemView.findViewById(R.id.attrib_key);
            attrib_value = (TextView) itemView.findViewById(R.id.attrib_value);

        }
    }
}
