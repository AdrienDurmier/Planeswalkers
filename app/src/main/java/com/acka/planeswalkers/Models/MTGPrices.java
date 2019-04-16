package com.acka.planeswalkers.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MTGPrices {

    @SerializedName("usd")
    @Expose
    private Object usd;
    @SerializedName("usd_foil")
    @Expose
    private Object usdFoil;
    @SerializedName("eur")
    @Expose
    private Object eur;
    @SerializedName("tix")
    @Expose
    private Object tix;

    public Object getUsd() {
        return usd;
    }

    public void setUsd(Object usd) {
        this.usd = usd;
    }

    public Object getUsdFoil() {
        return usdFoil;
    }

    public void setUsdFoil(Object usdFoil) {
        this.usdFoil = usdFoil;
    }

    public Object getEur() {
        return eur;
    }

    public void setEur(Object eur) {
        this.eur = eur;
    }

    public Object getTix() {
        return tix;
    }

    public void setTix(Object tix) {
        this.tix = tix;
    }

}