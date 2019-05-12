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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.acka.planeswalkers.Models.MTGCard;
import com.acka.planeswalkers.Models.MTGCardList;
import com.acka.planeswalkers.Utils.ScryfallStreams;
import com.acka.planeswalkers.Views.MTGCardAdapter;
import com.acka.planeswalkers.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class MTGSearchFragment extends Fragment implements MTGCardAdapter.Listener {

    public static MTGSearchFragment newInstance() {
        return (new MTGSearchFragment());
    }

    // FOR DESIGN
    @BindView(R.id.fragment_search_recycler_view) RecyclerView recyclerView;
    @BindView(R.id.fragment_search_swipe_container) SwipeRefreshLayout swipeRefreshLayout;

    //FOR DATA
    private Disposable disposable;
    private List<MTGCard> mtgCards;
    private MTGCardAdapter adapter;

    public MTGSearchFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mtgsearch, container, false);
        ButterKnife.bind(this, view);
        this.configureRecyclerView();

        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            String code = bundle.getString("query");
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
        this.disposeWhenDestroy();
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

    private void executeHttpRequestWithRetrofit(String query){
        this.disposable = ScryfallStreams.streamFetchSearchMTGCard("name:" + query).subscribeWith(new DisposableObserver<MTGCardList>() {
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
        mtgCards.clear();
        mtgCards.addAll(mtgCardList.getData());
        adapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

}
