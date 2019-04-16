package com.acka.planeswalkers.Controllers.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.acka.planeswalkers.Utils.ItemClickSupport;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements MTGCardAdapter.Listener, ItemClickSupport.OnItemClickListener {

    // FOR DESIGN
    @BindView(R.id.fragment_main_recycler_view) RecyclerView recyclerView;
    @BindView(R.id.fragment_main_swipe_container) SwipeRefreshLayout swipeRefreshLayout;

    //FOR DATA
    private Disposable disposable;
    private List<MTGCard> mtgCards;
    private MTGCardAdapter adapter;

    // Declare callback
    private MyItemClickListener mCallback;

    public interface MyItemClickListener {
        public void onItemClicked(MTGCard mtgCard);
    }

    public MainFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        this.configureRecyclerView();
        this.configureSwipeRefreshLayout();
        this.configureOnClickRecyclerView();
        this.executeHttpRequestWithRetrofit();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // Call the method that creating callback after being attached to parent activity
        this.createCallbackToParentActivity();
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
    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
        MTGCard mtgCard = adapter.getMTGCard(position);

        // Spread the click to the parent activity
        mCallback.onItemClicked(mtgCard);
    }

    private void configureOnClickRecyclerView(){
        // Set onClickListener to one item (of recycler view)
        ItemClickSupport.addTo(recyclerView, R.layout.fragment_main_item).setOnItemClickListener(this);
    }

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

    private void configureSwipeRefreshLayout(){
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                executeHttpRequestWithRetrofit();
            }
        });
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
        mtgCards.clear();
        mtgCards.addAll(mtgCardList.getData());
        adapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    private void createCallbackToParentActivity(){
        try {
            //Parent activity will automatically subscribe to callback
            mCallback = (MyItemClickListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }
    }

}
