package com.acka.planeswalkers.Models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MTGSet {

    @SerializedName("object")
    @Expose
    private String object;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("mtgo_code")
    @Expose
    private String mtgoCode;
    @SerializedName("tcgplayer_id")
    @Expose
    private Integer tcgplayerId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("scryfall_uri")
    @Expose
    private String scryfallUri;
    @SerializedName("search_uri")
    @Expose
    private String searchUri;
    @SerializedName("released_at")
    @Expose
    private String releasedAt;
    @SerializedName("set_type")
    @Expose
    private String setType;
    @SerializedName("card_count")
    @Expose
    private Integer cardCount;
    @SerializedName("digital")
    @Expose
    private Boolean digital;
    @SerializedName("foil_only")
    @Expose
    private Boolean foilOnly;
    @SerializedName("block_code")
    @Expose
    private String blockCode;
    @SerializedName("block")
    @Expose
    private String block;
    @SerializedName("icon_svg_uri")
    @Expose
    private String iconSvgUri;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMtgoCode() {
        return mtgoCode;
    }

    public void setMtgoCode(String mtgoCode) {
        this.mtgoCode = mtgoCode;
    }

    public Integer getTcgplayerId() {
        return tcgplayerId;
    }

    public void setTcgplayerId(Integer tcgplayerId) {
        this.tcgplayerId = tcgplayerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getScryfallUri() {
        return scryfallUri;
    }

    public void setScryfallUri(String scryfallUri) {
        this.scryfallUri = scryfallUri;
    }

    public String getSearchUri() {
        return searchUri;
    }

    public void setSearchUri(String searchUri) {
        this.searchUri = searchUri;
    }

    public String getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(String releasedAt) {
        this.releasedAt = releasedAt;
    }

    public String getSetType() {
        return setType;
    }

    public void setSetType(String setType) {
        this.setType = setType;
    }

    public Integer getCardCount() {
        return cardCount;
    }

    public void setCardCount(Integer cardCount) {
        this.cardCount = cardCount;
    }

    public Boolean getDigital() {
        return digital;
    }

    public void setDigital(Boolean digital) {
        this.digital = digital;
    }

    public Boolean getFoilOnly() {
        return foilOnly;
    }

    public void setFoilOnly(Boolean foilOnly) {
        this.foilOnly = foilOnly;
    }

    public String getBlockCode() {
        return blockCode;
    }

    public void setBlockCode(String blockCode) {
        this.blockCode = blockCode;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getIconSvgUri() {
        return iconSvgUri;
    }

    public void setIconSvgUri(String iconSvgUri) {
        this.iconSvgUri = iconSvgUri;
    }

}