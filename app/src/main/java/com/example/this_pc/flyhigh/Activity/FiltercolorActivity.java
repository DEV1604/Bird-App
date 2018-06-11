package com.example.this_pc.flyhigh.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.this_pc.flyhigh.R;
import com.example.this_pc.flyhigh.adapter.ColorAdapter;
import com.example.this_pc.flyhigh.utils.C;

import java.util.ArrayList;
import java.util.List;

public class FiltercolorActivity extends AppCompatActivity {

    ImageView recieve_img;
    Bitmap bitmap;
    RecyclerView recyclerView;
    Palette palette;
    List<Palette.Swatch> swatches;
    Button next_btn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flitercolor);

        recieve_img = (ImageView) findViewById(R.id.recieve_img);

        bitmap = C.cameraBitmap;

        recieve_img.setImageBitmap(bitmap);

        palette = Palette.from(bitmap).generate();

        swatches = new ArrayList<>();
        /*swatches.add(palette.getDominantSwatch());*/
        swatches.add(palette.getMutedSwatch());
        swatches.add(palette.getLightMutedSwatch());
        swatches.add(palette.getDarkMutedSwatch());
        swatches.add(palette.getVibrantSwatch());
        swatches.add(palette.getLightVibrantSwatch());
        swatches.add(palette.getDarkVibrantSwatch());
        swatches.addAll(palette.getSwatches());
        swatches = checkSwatch(swatches);


        recyclerView = (RecyclerView) findViewById(R.id.color_palette);
        recyclerView.setLayoutManager(new GridLayoutManager(FiltercolorActivity.this, 6, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new ColorAdapter(swatches));

        next_btn=(Button)findViewById(R.id.next_btn);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(FiltercolorActivity.this,FilterbirdActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<Palette.Swatch> checkSwatch(List<Palette.Swatch> palette) {
        List<Palette.Swatch> newList = new ArrayList<>();
        for (int i = 0; i < palette.size(); i++) {
            if (palette.get(i) != null)
                newList.add(palette.get(i));
        }
        return newList;
    }
}
