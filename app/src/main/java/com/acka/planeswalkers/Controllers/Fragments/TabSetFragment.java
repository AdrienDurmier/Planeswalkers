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
import com.acka.planeswalkers.Models.MTGSet;
import com.acka.planeswalkers.Models.MTGSetList;
import com.acka.planeswalkers.Utils.ScryfallStreams;
import com.acka.planeswalkers.Views.MTGSetAdapter;
import com.acka.planeswalkers.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class TabSetFragment extends Fragment implements MTGSetAdapter.Listener, ItemClickSupport.OnItemClickListener {

    public static TabSetFragment newInstance() {
        return (new TabSetFragment());
    }

    // FOR DESIGN
    @BindView(R.id.fragment_tab_set_recycler_view) RecyclerView recyclerView;
    @BindView(R.id.fragment_tab_set_swipe_container) SwipeRefreshLayout swipeRefreshLayout;

    //FOR DATA
    private Disposable disposable;
    private List<MTGSet> mtgSets;
    private MTGSetAdapter adapter;

    // Declare callback
    private MyItemClickListener mCallback;

    public interface MyItemClickListener {
        public void onItemClicked(MTGSet mtgSet);
    }

    public TabSetFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_set_fragment, container, false);
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
        MTGSet mtgSet = adapter.getMTGSet(position);
        mCallback.onItemClicked(mtgSet);
    }

    private void configureOnClickRecyclerView(){
        ItemClickSupport.addTo(recyclerView, R.layout.fragment_sets_item).setOnItemClickListener(this);
    }

    @Override
    public void onClickDeleteButton(int position) {
        MTGSet mtgSet = adapter.getMTGSet(position);
        Toast.makeText(getContext(), "You are trying to delete set : " + mtgSet.getName(), Toast.LENGTH_SHORT).show();
    }

    // -----------------
    // CONFIGURATION
    // -----------------

    private void configureRecyclerView(){
        this.mtgSets = new ArrayList<>();
        this.adapter = new MTGSetAdapter(this.mtgSets, Glide.with(this), this);
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
        this.disposable = ScryfallStreams.streamFetchListMTGSet().subscribeWith(new DisposableObserver<MTGSetList>() {
            @Override
            public void onNext(MTGSetList mtgSetList) {
                updateUI(mtgSetList);
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

    private void updateUI(MTGSetList mtgSetList){
        mtgSets.clear();
        mtgSets.addAll(mtgSetList.getData());
        adapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    private void createCallbackToParentActivity(){
        try {
            mCallback = (MyItemClickListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }
    }
}
