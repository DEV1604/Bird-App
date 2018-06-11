package com.example.this_pc.flyhigh.interfaces;

import com.example.this_pc.flyhigh.pojo.FilterImageListp;
import com.example.this_pc.flyhigh.pojo.FilterList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/filters/list")
    Call<FilterList> getFilters();

    @GET("/birds/list")
    Call<FilterImageListp> getImageFilter();
}
