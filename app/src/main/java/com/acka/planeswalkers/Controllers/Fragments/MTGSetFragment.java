package com.acka.planeswalkers.Controllers.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.acka.planeswalkers.Controllers.Activities.MTGSetActivity;
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

    private void executeHttpRequestWithRetrofit(String id){
        this.disposable = ScryfallStreams.streamFetchMTGSet(id).subscribeWith(new DisposableObserver<MTGSet>() {
            @Override
            public void onNext(MTGSet mtgSet) {
                try{
                    Log.i(TAG, "LOG: MTG Set name : "+ mtgSet.getName());
                }catch (Exception e){
                    Log.e(TAG, e.getMessage());
                }

                updateUi(mtgSet);
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

    private void updateUi(MTGSet mtgSet){
        ((MTGSetActivity)getActivity()).getSupportActionBar().setTitle(mtgSet.getName());
        this.mCardCount.setText(String.valueOf(mtgSet.getCardCount()));
        this.mReleasedAt.setText(mtgSet.getReleasedAt());
        this.mBlock.setText(mtgSet.getBlock());
    }

}

