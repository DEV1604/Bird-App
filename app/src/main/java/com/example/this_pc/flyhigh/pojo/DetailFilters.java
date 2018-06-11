
package com.example.this_pc.flyhigh.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailFilters {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sub-filter")
    @Expose
    private List<String> subFilter = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSubFilter() {
        return subFilter;
    }

    public void setSubFilter(List<String> subFilter) {
        this.subFilter = subFilter;
    }

}
