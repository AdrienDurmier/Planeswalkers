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
    @BindView(R.id.fragment_mtgcard_name) TextView mName;
    @BindView(R.id.fragment_mtgcard_type_line) TextView mTypeLine;
    @BindView(R.id.fragment_mtgcard_oracle_text) TextView mOracleText;

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
        this.mName.setText(mtgCard.getName());
        this.mTypeLine.setText(mtgCard.getTypeLine());
        this.mOracleText.setText(mtgCard.getOracleText());
        Glide.with(this).load(mtgCard.getImageUris().getArtCrop()).apply(RequestOptions.circleCropTransform()).into(mImage);
    }

}

