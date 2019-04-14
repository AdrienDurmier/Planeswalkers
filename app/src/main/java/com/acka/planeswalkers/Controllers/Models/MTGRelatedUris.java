package com.acka.planeswalkers.Controllers.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MTGRelatedUris {

    @SerializedName("gatherer")
    @Expose
    private String gatherer;
    @SerializedName("tcgplayer_decks")
    @Expose
    private String tcgplayerDecks;
    @SerializedName("edhrec")
    @Expose
    private String edhrec;
    @SerializedName("mtgtop8")
    @Expose
    private String mtgtop8;

    public String getGatherer() {
        return gatherer;
    }

    public void setGatherer(String gatherer) {
        this.gatherer = gatherer;
    }

    public String getTcgplayerDecks() {
        return tcgplayerDecks;
    }

    public void setTcgplayerDecks(String tcgplayerDecks) {
        this.tcgplayerDecks = tcgplayerDecks;
    }

    public String getEdhrec() {
        return edhrec;
    }

    public void setEdhrec(String edhrec) {
        this.edhrec = edhrec;
    }

    public String getMtgtop8() {
        return mtgtop8;
    }

    public void setMtgtop8(String mtgtop8) {
        this.mtgtop8 = mtgtop8;
    }

}