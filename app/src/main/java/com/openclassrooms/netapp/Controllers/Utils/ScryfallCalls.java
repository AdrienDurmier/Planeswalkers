package com.openclassrooms.netapp.Controllers.Utils;

import android.support.annotation.Nullable;

import com.openclassrooms.netapp.Controllers.Models.MTGSet;

import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Classe permettant de faire les appels en arrière plan
 */
public class ScryfallCalls {

    public interface  Callbacks {
        void onResponse(@Nullable List<MTGSet> sets);
        void onFailure();
    }

    public static void fetchSets(Callbacks callbacks){
        final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<Callbacks>(callbacks);

        ScryfallService scryfallService = ScryfallService.retrofit.create(ScryfallService.class);

        Call<List<MTGSet>> call = scryfallService.getSets();

        call.enqueue(new Callback<List<MTGSet>>() {
            @Override
            public void onResponse(Call<List<MTGSet>> call, Response<List<MTGSet>> response) {
                if(callbacksWeakReference.get() != null) callbacksWeakReference.get().onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<MTGSet>> call, Throwable t) {
                if(callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
            }
        });
    }
}
