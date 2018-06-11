
package com.example.this_pc.flyhigh.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilterImageListp {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("details")
    @Expose
    private List<Detail_imageFilter> details = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Detail_imageFilter> getDetails() {
        return details;
    }

    public void setDetails(List<Detail_imageFilter> details) {
        this.details = details;
    }

}
