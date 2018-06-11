package com.example.this_pc.flyhigh.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.this_pc.flyhigh.R;
import com.example.this_pc.flyhigh.adapter.FilterAdapter;
import com.example.this_pc.flyhigh.adapter.FilterImageAdapter;
import com.example.this_pc.flyhigh.interfaces.ApiClient;
import com.example.this_pc.flyhigh.interfaces.ApiInterface;
import com.example.this_pc.flyhigh.pojo.DetailFilters;
import com.example.this_pc.flyhigh.pojo.Detail_imageFilter;
import com.example.this_pc.flyhigh.pojo.FilterImageListp;
import com.example.this_pc.flyhigh.pojo.FilterList;
import com.example.this_pc.flyhigh.utils.C;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilterbirdActivity extends AppCompatActivity {

    ImageView img_to_be_compared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filterbird);

        img_to_be_compared = (ImageView) findViewById(R.id.img_to_be_compared);

        img_to_be_compared.setImageBitmap(C.cameraBitmap);

        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        /*Start of filters view*/
        Call<FilterList> call_1 = service.getFilters();
        call_1.enqueue(new Callback<FilterList>() {
            @Override
            public void onResponse(Call<FilterList> call_1, Response<FilterList> response) {
                if (response.isSuccessful()) {
                    FilterList filters = response.body();
                    List<DetailFilters> details = filters.getDetails();

                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.filter_view);
                    recyclerView.setLayoutManager(new LinearLayoutManager(FilterbirdActivity.this,LinearLayoutManager.HORIZONTAL,false));
                    recyclerView.setAdapter(new FilterAdapter(details));

                } else {
                    Toast.makeText(FilterbirdActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FilterList> call_1, Throwable t) {

                Log.d("Error", t.getMessage());
                Toast.makeText(FilterbirdActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
        /*End of Filters view*/

        /*Start of imageview filters*/
        Call<FilterImageListp> call_2 = service.getImageFilter();
        call_2.enqueue(new Callback<FilterImageListp>() {
            @Override
            public void onResponse(Call<FilterImageListp> call, Response<FilterImageListp> response) {
                if (response.isSuccessful()){
                    FilterImageListp filters = response.body();
                    List<Detail_imageFilter> details = filters.getDetails();

                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.image_list_view);
                    recyclerView.setLayoutManager(new GridLayoutManager(FilterbirdActivity.this,2,LinearLayoutManager.VERTICAL,false));
                    recyclerView.setAdapter(new FilterImageAdapter(details));

                } else {
                    Toast.makeText(FilterbirdActivity.this,"error in img part",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<FilterImageListp> call, Throwable t) {
                Log.d("Error in image",t.getMessage());
                Toast.makeText(FilterbirdActivity.this,"something isn't right in image part ",Toast.LENGTH_LONG).show();
            }
        });
        /*End of imageview filters*/
    }
}