package com.acka.planeswalkers.Models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MTGCard {

    @SerializedName("object")
    @Expose
    private String object;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("oracle_id")
    @Expose
    private String oracleId;
    @SerializedName("multiverse_ids")
    @Expose
    private List<Integer> multiverseIds = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("printed_name")
    @Expose
    private String printedName;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("released_at")
    @Expose
    private String releasedAt;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("scryfall_uri")
    @Expose
    private String scryfallUri;
    @SerializedName("layout")
    @Expose
    private String layout;
    @SerializedName("highres_image")
    @Expose
    private Boolean highresImage;
    @SerializedName("image_uris")
    @Expose
    private MTGImageUris imageUris;
    @SerializedName("mana_cost")
    @Expose
    private String manaCost;
    @SerializedName("cmc")
    @Expose
    private Integer cmc;
    @SerializedName("type_line")
    @Expose
    private String typeLine;
    @SerializedName("printed_type_line")
    @Expose
    private String printedTypeLine;
    @SerializedName("oracle_text")
    @Expose
    private String oracleText;
    @SerializedName("printed_text")
    @Expose
    private String printedText;
    @SerializedName("power")
    @Expose
    private String power;
    @SerializedName("toughness")
    @Expose
    private String toughness;
    @SerializedName("colors")
    @Expose
    private List<String> colors = null;
    @SerializedName("color_identity")
    @Expose
    private List<String> colorIdentity = null;
    @SerializedName("legalities")
    @Expose
    private MTGLegalities legalities;
    @SerializedName("games")
    @Expose
    private List<String> games = null;
    @SerializedName("reserved")
    @Expose
    private Boolean reserved;
    @SerializedName("foil")
    @Expose
    private Boolean foil;
    @SerializedName("nonfoil")
    @Expose
    private Boolean nonfoil;
    @SerializedName("oversized")
    @Expose
    private Boolean oversized;
    @SerializedName("promo")
    @Expose
    private Boolean promo;
    @SerializedName("reprint")
    @Expose
    private Boolean reprint;
    @SerializedName("set")
    @Expose
    private String set;
    @SerializedName("set_name")
    @Expose
    private String setName;
    @SerializedName("set_uri")
    @Expose
    private String setUri;
    @SerializedName("set_search_uri")
    @Expose
    private String setSearchUri;
    @SerializedName("scryfall_set_uri")
    @Expose
    private String scryfallSetUri;
    @SerializedName("rulings_uri")
    @Expose
    private String rulingsUri;
    @SerializedName("prints_search_uri")
    @Expose
    private String printsSearchUri;
    @SerializedName("collector_number")
    @Expose
    private String collectorNumber;
    @SerializedName("digital")
    @Expose
    private Boolean digital;
    @SerializedName("rarity")
    @Expose
    private String rarity;
    @SerializedName("flavor_text")
    @Expose
    private String flavorText;
    @SerializedName("illustration_id")
    @Expose
    private String illustrationId;
    @SerializedName("artist")
    @Expose
    private String artist;
    @SerializedName("border_color")
    @Expose
    private String borderColor;
    @SerializedName("frame")
    @Expose
    private String frame;
    @SerializedName("full_art")
    @Expose
    private Boolean fullArt;
    @SerializedName("story_spotlight")
    @Expose
    private Boolean storySpotlight;
    @SerializedName("edhrec_rank")
    @Expose
    private Integer edhrecRank;
    @SerializedName("prices")
    @Expose
    private MTGPrices prices;
    @SerializedName("related_uris")
    @Expose
    private MTGRelatedUris relatedUris;
    @SerializedName("purchase_uris")
    @Expose
    private MTGPurchaseUris purchaseUris;

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

    public String getOracleId() {
        return oracleId;
    }

    public void setOracleId(String oracleId) {
        this.oracleId = oracleId;
    }

    public List<Integer> getMultiverseIds() {
        return multiverseIds;
    }

    public void setMultiverseIds(List<Integer> multiverseIds) {
        this.multiverseIds = multiverseIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrintedName() {
        return printedName;
    }

    public void setPrintedName(String printedName) {
        this.printedName = printedName;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(String releasedAt) {
        this.releasedAt = releasedAt;
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

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public Boolean getHighresImage() {
        return highresImage;
    }

    public void setHighresImage(Boolean highresImage) {
        this.highresImage = highresImage;
    }

    public MTGImageUris getImageUris() {
        return imageUris;
    }

    public void setImageUris(MTGImageUris imageUris) {
        this.imageUris = imageUris;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public Integer getCmc() {
        return cmc;
    }

    public void setCmc(Integer cmc) {
        this.cmc = cmc;
    }

    public String getTypeLine() {
        return typeLine;
    }

    public void setTypeLine(String typeLine) {
        this.typeLine = typeLine;
    }

    public String getPrintedTypeLine() {
        return printedTypeLine;
    }

    public void setPrintedTypeLine(String printedTypeLine) {
        this.printedTypeLine = printedTypeLine;
    }

    public String getOracleText() {
        return oracleText;
    }

    public void setOracleText(String oracleText) {
        this.oracleText = oracleText;
    }

    public String getPrintedText() {
        return printedText;
    }

    public void setPrintedText(String printedText) {
        this.printedText = printedText;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public List<String> getColorIdentity() {
        return colorIdentity;
    }

    public void setColorIdentity(List<String> colorIdentity) {
        this.colorIdentity = colorIdentity;
    }

    public MTGLegalities getLegalities() {
        return legalities;
    }

    public void setLegalities(MTGLegalities legalities) {
        this.legalities = legalities;
    }

    public List<String> getGames() {
        return games;
    }

    public void setGames(List<String> games) {
        this.games = games;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public Boolean getFoil() {
        return foil;
    }

    public void setFoil(Boolean foil) {
        this.foil = foil;
    }

    public Boolean getNonfoil() {
        return nonfoil;
    }

    public void setNonfoil(Boolean nonfoil) {
        this.nonfoil = nonfoil;
    }

    public Boolean getOversized() {
        return oversized;
    }

    public void setOversized(Boolean oversized) {
        this.oversized = oversized;
    }

    public Boolean getPromo() {
        return promo;
    }

    public void setPromo(Boolean promo) {
        this.promo = promo;
    }

    public Boolean getReprint() {
        return reprint;
    }

    public void setReprint(Boolean reprint) {
        this.reprint = reprint;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getSetUri() {
        return setUri;
    }

    public void setSetUri(String setUri) {
        this.setUri = setUri;
    }

    public String getSetSearchUri() {
        return setSearchUri;
    }

    public void setSetSearchUri(String setSearchUri) {
        this.setSearchUri = setSearchUri;
    }

    public String getScryfallSetUri() {
        return scryfallSetUri;
    }

    public void setScryfallSetUri(String scryfallSetUri) {
        this.scryfallSetUri = scryfallSetUri;
    }

    public String getRulingsUri() {
        return rulingsUri;
    }

    public void setRulingsUri(String rulingsUri) {
        this.rulingsUri = rulingsUri;
    }

    public String getPrintsSearchUri() {
        return printsSearchUri;
    }

    public void setPrintsSearchUri(String printsSearchUri) {
        this.printsSearchUri = printsSearchUri;
    }

    public String getCollectorNumber() {
        return collectorNumber;
    }

    public void setCollectorNumber(String collectorNumber) {
        this.collectorNumber = collectorNumber;
    }

    public Boolean getDigital() {
        return digital;
    }

    public void setDigital(Boolean digital) {
        this.digital = digital;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public String getIllustrationId() {
        return illustrationId;
    }

    public void setIllustrationId(String illustrationId) {
        this.illustrationId = illustrationId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public Boolean getFullArt() {
        return fullArt;
    }

    public void setFullArt(Boolean fullArt) {
        this.fullArt = fullArt;
    }

    public Boolean getStorySpotlight() {
        return storySpotlight;
    }

    public void setStorySpotlight(Boolean storySpotlight) {
        this.storySpotlight = storySpotlight;
    }

    public Integer getEdhrecRank() {
        return edhrecRank;
    }

    public void setEdhrecRank(Integer edhrecRank) {
        this.edhrecRank = edhrecRank;
    }

    public MTGPrices getPrices() {
        return prices;
    }

    public void setPrices(MTGPrices prices) {
        this.prices = prices;
    }

    public MTGRelatedUris getRelatedUris() {
        return relatedUris;
    }

    public void setRelatedUris(MTGRelatedUris relatedUris) {
        this.relatedUris = relatedUris;
    }

    public MTGPurchaseUris getPurchaseUris() {
        return purchaseUris;
    }

    public void setPurchaseUris(MTGPurchaseUris purchaseUris) {
        this.purchaseUris = purchaseUris;
    }

}
