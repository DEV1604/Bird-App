package com.example.this_pc.flyhigh.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.this_pc.flyhigh.R;
import com.example.this_pc.flyhigh.adapter.AttributesAdapter;
import com.example.this_pc.flyhigh.pojo.Detail_imageFilter;
import com.example.this_pc.flyhigh.utils.C;
import com.example.this_pc.flyhigh.utils.Listdetails;

public class BirdattributesActivity extends AppCompatActivity {

    ImageView final_img;
    Detail_imageFilter details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birdattributes);

        final_img=(ImageView) findViewById(R.id.final_img);
        Glide.with(BirdattributesActivity.this)
                .load(C.img2cmp_URL)
                .into(final_img);

        details= Listdetails.detail_imageFilter;
        Log.d("keys values",details.toString());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.attributes_list);
        recyclerView.setLayoutManager(new GridLayoutManager(BirdattributesActivity.this,1,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new AttributesAdapter(details));

    }
}
