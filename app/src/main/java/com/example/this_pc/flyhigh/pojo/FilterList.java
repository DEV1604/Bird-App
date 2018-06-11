
package com.example.this_pc.flyhigh.pojo;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilterList {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("details")
    @Expose
    private List<DetailFilters> details = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<DetailFilters> getDetails() {
        return details;
    }

    public void setDetails(List<DetailFilters> details) {
        this.details = details;
    }

}
