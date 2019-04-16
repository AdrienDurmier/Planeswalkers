package com.acka.planeswalkers.Utils;

import com.acka.planeswalkers.Models.MTGCard;
import com.acka.planeswalkers.Models.MTGCardList;
import com.acka.planeswalkers.Models.MTGSet;
import com.acka.planeswalkers.Models.MTGSetList;

import java.util.UUID;
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

    public static Observable<MTGCard> streamFetchMTGCard(String id){
        ScryfallService scryfallService = ScryfallService.retrofit.create(ScryfallService.class);
        return scryfallService.getMTGCard(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }


}
