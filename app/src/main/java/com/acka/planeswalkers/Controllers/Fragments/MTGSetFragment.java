package com.acka.planeswalkers.Controllers.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.acka.planeswalkers.Controllers.Activities.MTGSetActivity;
import com.acka.planeswalkers.Models.MTGCard;
import com.acka.planeswalkers.Models.MTGCardList;
import com.acka.planeswalkers.Models.MTGSet;
import com.acka.planeswalkers.R;
import com.acka.planeswalkers.Utils.ItemClickSupport;
import com.acka.planeswalkers.Utils.ScryfallStreams;
import com.acka.planeswalkers.Views.MTGCardAdapter;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class MTGSetFragment extends Fragment implements MTGCardAdapter.Listener {

    private static final String TAG = "SetFragment";

    // FOR DESIGN
    @BindView(R.id.fragment_mtgset_card_count) TextView mCardCount;
    @BindView(R.id.fragment_mtgset_released_at) TextView mReleasedAt;
    @BindView(R.id.fragment_mtgset_block) TextView mBlock;
    @BindView(R.id.fragment_set_card_recycler_view) RecyclerView recyclerView;
    @BindView(R.id.fragment_set_card_swipe_container) SwipeRefreshLayout swipeRefreshLayout;

    //FOR DATA
    private Disposable disposable;
    private List<MTGCard> mtgCards;
    private MTGCardAdapter adapter;

    public MTGSetFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mtgset, container, false);
        ButterKnife.bind(this, view);
        this.configureRecyclerView();
        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            String code = bundle.getString("code");
            this.executeHttpRequestWithRetrofit(code);
        }

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.disposeWhenDestroy(); // Gestion des memory leak
    }

    // -----------------
    // ACTION
    // -----------------

    @Override
    public void onClickDeleteButton(int position) {
        MTGCard mtgCard = adapter.getMTGCard(position);
        Toast.makeText(getContext(), "You are trying to delete card : " + mtgCard.getName(), Toast.LENGTH_SHORT).show();
    }

    // -----------------
    // CONFIGURATION
    // -----------------

    private void configureRecyclerView(){
        this.mtgCards = new ArrayList<>();
        this.adapter = new MTGCardAdapter(this.mtgCards, Glide.with(this), this);
        this.recyclerView.setAdapter(this.adapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
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
        mtgCards.clear();
        mtgCards.addAll(mtgCardList.getData());
        adapter.notifyDataSetChanged();
    }

}

