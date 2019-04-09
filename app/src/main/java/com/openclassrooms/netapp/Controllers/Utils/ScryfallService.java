package com.openclassrooms.netapp.Controllers.Utils;

import com.openclassrooms.netapp.Controllers.Models.MTGDatum;
import com.openclassrooms.netapp.Controllers.Models.MTGSet;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ScryfallService {

    @GET("sets")
    Observable<List<MTGSet>> getSets();

    @GET("/sets/{code}")
    Observable<MTGDatum> getSetDatum(@Path("code") String code);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.scryfall.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
}
