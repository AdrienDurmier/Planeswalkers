package com.acka.planeswalkers.Controllers.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.acka.planeswalkers.Controllers.Activities.MTGSetActivity;
import com.acka.planeswalkers.Models.MTGCardList;
import com.acka.planeswalkers.Models.MTGSet;
import com.acka.planeswalkers.R;
import com.acka.planeswalkers.Utils.ScryfallStreams;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class MTGSetFragment extends Fragment {

    private static final String TAG = "SetFragment";

    // FOR DESIGN
    @BindView(R.id.fragment_mtgset_card_count) TextView mCardCount;
    @BindView(R.id.fragment_mtgset_released_at) TextView mReleasedAt;
    @BindView(R.id.fragment_mtgset_block) TextView mBlock;

    //FOR DATA
    private Disposable disposable;

    public MTGSetFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mtgset, container, false);

        ButterKnife.bind(this, view);

        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            String code = bundle.getString("code");
            this.executeHttpRequestWithRetrofit(code);
        }

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.disposeWhenDestroy(); // Gestion des memory leak
    }

    // -------------------
    // HTTP (RxJAVA)
    // -------------------

    private void executeHttpRequestWithRetrofit(String code){
       this.disposable = ScryfallStreams.streamFetchMTGSet(code).subscribeWith(new DisposableObserver<MTGSet>() {
            @Override
            public void onNext(MTGSet mtgSet) {
                updateSetUi(mtgSet);
            }

            @Override
            public void onError(Throwable e) { }

            @Override
            public void onComplete() { }
        });
        this.disposable = ScryfallStreams.streamFetchSearchMTGCard("set:" + code).subscribeWith(new DisposableObserver<MTGCardList>() {
            @Override
            public void onNext(MTGCardList mtgCardList) {
                updateCardsUi(mtgCardList);
            }

            @Override
            public void onError(Throwable e) { }

            @Override
            public void onComplete() { }
        });
    }

    private void disposeWhenDestroy(){
        if (this.disposable != null && !this.disposable.isDisposed()) this.disposable.dispose();
    }

    private void updateSetUi(MTGSet mtgSet){
        String toolbarTitle = mtgSet.getName();
        if(mtgSet.getBlockCode() != null){
            toolbarTitle += " (" + mtgSet.getBlockCode().toUpperCase() + ")";
        }
        ((MTGSetActivity)getActivity()).getSupportActionBar().setTitle(toolbarTitle);
        this.mCardCount.setText(String.valueOf(mtgSet.getCardCount()));
        this.mReleasedAt.setText(mtgSet.getReleasedAt());
        this.mBlock.setText(mtgSet.getBlock());
    }

    private void updateCardsUi(MTGCardList mtgCardList){
        this.mCardCount.setText(String.valueOf(mtgCardList.getData()));
    }

}

