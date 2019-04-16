package com.acka.planeswalkers.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MTGRuling {

    @SerializedName("object")
    @Expose
    private String object;
    @SerializedName("oracle_id")
    @Expose
    private String oracleId;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("comment")
    @Expose
    private String comment;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getOracleId() {
        return oracleId;
    }

    public void setOracleId(String oracleId) {
        this.oracleId = oracleId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}