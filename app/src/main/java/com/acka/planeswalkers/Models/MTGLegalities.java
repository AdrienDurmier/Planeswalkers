package com.acka.planeswalkers.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MTGLegalities {

    @SerializedName("standard")
    @Expose
    private String standard;
    @SerializedName("future")
    @Expose
    private String future;
    @SerializedName("frontier")
    @Expose
    private String frontier;
    @SerializedName("modern")
    @Expose
    private String modern;
    @SerializedName("legacy")
    @Expose
    private String legacy;
    @SerializedName("pauper")
    @Expose
    private String pauper;
    @SerializedName("vintage")
    @Expose
    private String vintage;
    @SerializedName("penny")
    @Expose
    private String penny;
    @SerializedName("commander")
    @Expose
    private String commander;
    @SerializedName("duel")
    @Expose
    private String duel;
    @SerializedName("oldschool")
    @Expose
    private String oldschool;

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getFuture() {
        return future;
    }

    public void setFuture(String future) {
        this.future = future;
    }

    public String getFrontier() {
        return frontier;
    }

    public void setFrontier(String frontier) {
        this.frontier = frontier;
    }

    public String getModern() {
        return modern;
    }

    public void setModern(String modern) {
        this.modern = modern;
    }

    public String getLegacy() {
        return legacy;
    }

    public void setLegacy(String legacy) {
        this.legacy = legacy;
    }

    public String getPauper() {
        return pauper;
    }

    public void setPauper(String pauper) {
        this.pauper = pauper;
    }

    public String getVintage() {
        return vintage;
    }

    public void setVintage(String vintage) {
        this.vintage = vintage;
    }

    public String getPenny() {
        return penny;
    }

    public void setPenny(String penny) {
        this.penny = penny;
    }

    public String getCommander() {
        return commander;
    }

    public void setCommander(String commander) {
        this.commander = commander;
    }

    public String getDuel() {
        return duel;
    }

    public void setDuel(String duel) {
        this.duel = duel;
    }

    public String getOldschool() {
        return oldschool;
    }

    public void setOldschool(String oldschool) {
        this.oldschool = oldschool;
    }

}