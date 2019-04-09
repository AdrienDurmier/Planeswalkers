package com.openclassrooms.netapp.Controllers.Utils;

import com.openclassrooms.netapp.Controllers.Models.MTGDatum;
import com.openclassrooms.netapp.Controllers.Models.MTGSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ScryfallStreams {

    public static Observable<List<MTGSet>> streamFetchSets(){
        ScryfallService scryfallService = ScryfallService.retrofit.create(ScryfallService.class);
        return scryfallService.getSets()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }

    public static Observable<MTGDatum> streamFetchSetDatum(String code){
        ScryfallService scryfallService = ScryfallService.retrofit.create(ScryfallService.class);
        return scryfallService.getSetDatum(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }

}
