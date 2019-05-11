package com.acka.planeswalkers.Controllers.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.acka.planeswalkers.Controllers.Activities.MTGCardActivity;
import com.acka.planeswalkers.Models.MTGCard;
import com.acka.planeswalkers.Utils.ScryfallStreams;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.acka.planeswalkers.R;

import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class MTGCardFragment extends Fragment {

    private static final String TAG = "DetailFragment";

    // FOR DESIGN
    @BindView(R.id.fragment_mtgcard_image) ImageView mImage;
    @BindView(R.id.fragment_mtgcard_prices_usd) TextView mPricesUSD;
    @BindView(R.id.fragment_mtgcard_prices_eur) TextView mPricesEUR;
    @BindView(R.id.fragment_mtgcard_legalities_standard) TextView mLegalitiesStandard;
    @BindView(R.id.fragment_mtgcard_legalities_future) TextView mLegalitiesFuture;
    @BindView(R.id.fragment_mtgcard_legalities_frontier) TextView mLegalitiesFrontier;
    @BindView(R.id.fragment_mtgcard_legalities_modern) TextView mLegalitiesModern;
    @BindView(R.id.fragment_mtgcard_legalities_legacy) TextView mLegalitiesLegacy;
    @BindView(R.id.fragment_mtgcard_legalities_pauper) TextView mLegalitiesPauper;
    @BindView(R.id.fragment_mtgcard_legalities_vintage) TextView mLegalitiesVintage;
    @BindView(R.id.fragment_mtgcard_legalities_penny) TextView mLegalitiesPenny;
    @BindView(R.id.fragment_mtgcard_legalities_commander) TextView mLegalitiesCommander;
    @BindView(R.id.fragment_mtgcard_legalities_duel) TextView mLegalitiesDuel;
    @BindView(R.id.fragment_mtgcard_legalities_oldschool) TextView mLegalitiesOldschool;

    //FOR DATA
    private Disposable disposable;

    public MTGCardFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mtgcard, container, false);

        ButterKnife.bind(this, view);

        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            String id = bundle.getString("uuid");
            this.executeHttpRequestWithRetrofit(id);
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

    private void executeHttpRequestWithRetrofit(String id){
        this.disposable = ScryfallStreams.streamFetchMTGCard(id).subscribeWith(new DisposableObserver<MTGCard>() {
            @Override
            public void onNext(MTGCard mtgCard) {
                try{
                    Log.i(TAG, "LOG: MTG Card name : "+ mtgCard.getName());
                }catch (Exception e){
                    Log.e(TAG, e.getMessage());
                }

                updateUi(mtgCard);
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

    private void updateUi(MTGCard mtgCard){
        ((MTGCardActivity)getActivity()).getSupportActionBar().setTitle(mtgCard.getName());
        Glide.with(this).load(mtgCard.getImageUris().getBorderCrop()).into(mImage);
        // Prices
        if(mtgCard.getPrices().getUsd() != null){
            this.mPricesUSD.setText(mtgCard.getPrices().getUsd().toString() + "$");
        }
        if(mtgCard.getPrices().getEur() != null){
            this.mPricesEUR.setText(mtgCard.getPrices().getEur().toString() + "€");
        }
        // Legalities
        this.mLegalitiesStandard.setText(mtgCard.getLegalities().getStandard());
        this.mLegalitiesFuture.setText(mtgCard.getLegalities().getFuture());
        this.mLegalitiesFrontier.setText(mtgCard.getLegalities().getFrontier());
        this.mLegalitiesModern.setText(mtgCard.getLegalities().getModern());
        this.mLegalitiesLegacy.setText(mtgCard.getLegalities().getLegacy());
        this.mLegalitiesPauper.setText(mtgCard.getLegalities().getPauper());
        this.mLegalitiesVintage.setText(mtgCard.getLegalities().getVintage());
        this.mLegalitiesPenny.setText(mtgCard.getLegalities().getPenny());
        this.mLegalitiesCommander.setText(mtgCard.getLegalities().getCommander());
        this.mLegalitiesDuel.setText(mtgCard.getLegalities().getDuel());
        this.mLegalitiesOldschool.setText(mtgCard.getLegalities().getOldschool());
    }

}

