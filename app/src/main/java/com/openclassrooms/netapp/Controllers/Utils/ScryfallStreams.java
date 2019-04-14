package com.openclassrooms.netapp.Controllers.Utils;

import com.openclassrooms.netapp.Controllers.Models.MTGSet;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ScryfallStreams {

    public static Observable<List<MTGSet>> streamFetchMTGSets(){
        ScryfallService scryfallService = ScryfallService.retrofit.create(ScryfallService.class);
        return scryfallService.getMTGSets()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }

    public static Observable<MTGSet> streamFetchMTGSet(String code){
        ScryfallService scryfallService = ScryfallService.retrofit.create(ScryfallService.class);
        return scryfallService.getMTGSet(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }

}
