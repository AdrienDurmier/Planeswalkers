package com.openclassrooms.netapp.Controllers.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.openclassrooms.netapp.Controllers.Models.MTGCard;
import com.openclassrooms.netapp.Controllers.Models.MTGCardList;
import com.openclassrooms.netapp.Controllers.Utils.ScryfallStreams;
import com.openclassrooms.netapp.Controllers.Views.MTGCardAdapter;
import com.openclassrooms.netapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    // FOR DESIGN
    @BindView(R.id.fragment_main_recycler_view) RecyclerView recyclerView;

    //FOR DATA
    private Disposable disposable;
    private List<MTGCard> mtgCards;
    private MTGCardAdapter adapter;

    public MainFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        this.configureRecyclerView();
        this.executeHttpRequestWithRetrofit();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.disposeWhenDestroy();
    }

    // -----------------
    // CONFIGURATION
    // -----------------

    private void configureRecyclerView(){
        this.mtgCards = new ArrayList<>();
        this.adapter = new MTGCardAdapter(this.mtgCards, Glide.with(this));
        this.recyclerView.setAdapter(this.adapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    // -------------------
    // HTTP (RxJAVA)
    // -------------------

    private void executeHttpRequestWithRetrofit(){
        this.disposable = ScryfallStreams.streamFetchListMTGCard().subscribeWith(new DisposableObserver<MTGCardList>() {
            @Override
            public void onNext(MTGCardList mtgCardList) {
                updateUI(mtgCardList);
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

    // -------------------
    // UPDATE UI
    // -------------------

    private void updateUI(MTGCardList mtgCardList){
        mtgCards.addAll(mtgCardList.getData());
        adapter.notifyDataSetChanged();
    }

}
