package com.example.this_pc.flyhigh.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.this_pc.flyhigh.R;
import com.example.this_pc.flyhigh.adapter.AttributesAdapter;
import com.example.this_pc.flyhigh.interfaces.ApiClient;
import com.example.this_pc.flyhigh.interfaces.ApiInterface;
import com.example.this_pc.flyhigh.pojo.Detail_imageFilter;
import com.example.this_pc.flyhigh.pojo.FilterImageListp;
import com.example.this_pc.flyhigh.utils.C;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BirdattributesActivity extends AppCompatActivity {

    ImageView final_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birdattributes);

        final_img=(ImageView) findViewById(R.id.final_img);
        Glide.with(BirdattributesActivity.this)
                .load(C.img2cmp_URL)
                .into(final_img);
        ApiInterface service= ApiClient.getClient().create(ApiInterface.class);
        Call<FilterImageListp> call = service.getImageFilter();
        call.enqueue(new Callback<FilterImageListp>() {
            @Override
            public void onResponse(Call<FilterImageListp> call, Response<FilterImageListp> response) {
                if (response.isSuccessful()){
                    FilterImageListp attributes_fill = response.body();
                    List<Detail_imageFilter> all_attributes = attributes_fill.getDetails();

                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.attributes_list);
                    recyclerView.setLayoutManager(new GridLayoutManager(BirdattributesActivity.this,4, LinearLayoutManager.VERTICAL, false));
                    recyclerView.setAdapter(new AttributesAdapter(all_attributes));

                }
                else {
                    Log.d("error in reponse",response.message());
                    Toast.makeText(BirdattributesActivity.this, "error in retrieving a response on the 4th activity", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<FilterImageListp> call, Throwable t) {
                Log.d("engue failure",t.getMessage());
            }
        });
    }
}
