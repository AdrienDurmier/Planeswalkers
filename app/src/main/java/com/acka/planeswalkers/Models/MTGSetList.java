package com.acka.planeswalkers.Models;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MTGSetList {

    @SerializedName("object")
    @Expose
    private String object;
    @SerializedName("total_cards")
    @Expose
    private Integer totalCards;
    @SerializedName("has_more")
    @Expose
    private Boolean hasMore;
    @SerializedName("next_page")
    @Expose
    private String nextPage;
    @SerializedName("data")
    @Expose
    private List<MTGSet> data = null;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Integer getTotalCards() {
        return totalCards;
    }

    public void setTotalCards(Integer totalCards) {
        this.totalCards = totalCards;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public List<MTGSet> getData() {
        return data;
    }

    public void setData(List<MTGSet> data) {
        this.data = data;
    }

}