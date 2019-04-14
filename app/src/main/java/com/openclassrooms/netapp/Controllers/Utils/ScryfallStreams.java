package com.openclassrooms.netapp.Controllers.Utils;

import com.openclassrooms.netapp.Controllers.Models.MTGCardList;
import com.openclassrooms.netapp.Controllers.Models.MTGSet;
import com.openclassrooms.netapp.Controllers.Models.MTGSetList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ScryfallStreams {

    public static Observable<MTGSetList> streamFetchListMTGSet(){
        ScryfallService scryfallService = ScryfallService.retrofit.create(ScryfallService.class);
        return scryfallService.getListMTGSet()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(30, TimeUnit.SECONDS);
    }

    public static Observable<MTGSet> streamFetchMTGSet(String code){
        ScryfallService scryfallService = ScryfallService.retrofit.create(ScryfallService.class);
        return scryfallService.getMTGSet(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }

    public static Observable<MTGCardList> streamFetchListMTGCard(){
        ScryfallService scryfallService = ScryfallService.retrofit.create(ScryfallService.class);
        return scryfallService.getListMTGCard()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(30, TimeUnit.SECONDS);
    }

}
