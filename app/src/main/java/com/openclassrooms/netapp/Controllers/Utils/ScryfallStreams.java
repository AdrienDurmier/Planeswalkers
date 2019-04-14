package com.openclassrooms.netapp.Controllers.Utils;

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
                .subscribeOn(Schedulers.io()) // opérateur pour executer l'observable dans un thread dédié
                .observeOn(AndroidSchedulers.mainThread()) // permet à tous les subscribers d'écouter le flux de données sur le thread principal
                .timeout(30, TimeUnit.SECONDS);
    }

    public static Observable<MTGSet> streamFetchMTGSet(String code){
        ScryfallService scryfallService = ScryfallService.retrofit.create(ScryfallService.class);
        return scryfallService.getMTGSet(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }

    /*public static Observable<GithubUserInfo> streamFetchUserFollowingAndFetchFirstUserInfos(String username){
        return streamFetchUserFollowing(username) // A.
                .map(new Function<List<GithubUser>, GithubUser>() {
                    @Override
                    public GithubUser apply(List<GithubUser> users) throws Exception {
                        return users.get(0); // B.
                    }
                })
                .flatMap(new Function<GithubUser, Observable<GithubUserInfo>>() {
                    @Override
                    public Observable<GithubUserInfo> apply(GithubUser user) throws Exception {
                        // C.
                        return streamFetchUserInfos(user.getLogin());
                    }
                });
    }*/
}
