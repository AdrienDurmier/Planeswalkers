package com.openclassrooms.netapp.Controllers.Utils;

import com.openclassrooms.netapp.Controllers.Models.MTGSet;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ScryfallService {

    @GET("sets")
    Call<List<MTGSet>> getSets();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.scryfall.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
