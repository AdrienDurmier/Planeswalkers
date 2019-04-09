package com.openclassrooms.netapp.Controllers.Models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MTGSet {

    @SerializedName("object")
    @Expose
    private String object;
    @SerializedName("has_more")
    @Expose
    private Boolean hasMore;
    @SerializedName("data")
    @Expose
    private List<MTGDatum> data = null;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<MTGDatum> getData() {
        return data;
    }

    public void setData(List<MTGDatum> data) {
        this.data = data;
    }

}