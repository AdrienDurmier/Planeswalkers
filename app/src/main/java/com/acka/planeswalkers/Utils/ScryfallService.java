package com.acka.planeswalkers.Utils;

import com.acka.planeswalkers.Models.MTGSetList;
import com.acka.planeswalkers.Models.MTGSet;
import com.acka.planeswalkers.Models.MTGCardList;
import com.acka.planeswalkers.Models.MTGCard;

import java.util.UUID;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ScryfallService {

    /**
     * Retourne la liste des sets
     * @see "https://scryfall.com/docs/api/sets/all"
     * @return
     */
    @GET("sets")
    Observable<MTGSetList> getListMTGSet();

    /**
     * Retourne un set à partir de son code
     * @see "https://scryfall.com/docs/api/sets/code"
     * @param code
     * @return
     */
    @GET("/sets/{code}")
    Observable<MTGSet> getMTGSet(@Path("code") String code);

    /**
     * Retourne la liste des cards
     * @see "https://scryfall.com/docs/api/cards"
     * @return
     */
    @GET("/cards")
    Observable<MTGCardList> getListMTGCard();

    /**
     * Recherche de carte
     * @see "https://scryfall.com/docs/api/cards/search"
     * @return
     */
    @GET("/cards/search")
    Observable<MTGCardList> getSearchMTGCard(@Query("q") String query);

    /**
     * Retourne une carte à partir de son UUID
     * @see "https://scryfall.com/docs/api/cards/id"
     * @return
     */
    @GET("/cards/{id}")
    Observable<MTGCard> getMTGCard(@Path("id") String id);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.scryfall.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
}
