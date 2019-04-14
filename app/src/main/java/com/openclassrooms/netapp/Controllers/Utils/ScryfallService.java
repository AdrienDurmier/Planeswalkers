package com.openclassrooms.netapp.Controllers.Utils;

import com.openclassrooms.netapp.Controllers.Models.MTGSet;
import com.openclassrooms.netapp.Controllers.Models.MTGSetList;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ScryfallService {

    /**
     * Retourne la liste des sets
     * @see https://scryfall.com/docs/api/sets/all
     * @return
     */
    @GET("sets")
    Observable<MTGSetList> getListMTGSet();

    /**
     * Retourne un set à partir de son code
     * @see https://scryfall.com/docs/api/sets/code
     * @param code
     * @return
     */
    @GET("/sets/{code}")
    Observable<MTGSet> getMTGSet(@Path("code") String code);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.scryfall.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
}
