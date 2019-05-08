package com.acka.planeswalkers.Views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acka.planeswalkers.Models.MTGSet;
import com.acka.planeswalkers.R;
import com.bumptech.glide.RequestManager;

import java.util.List;

public class MTGSetAdapter extends RecyclerView.Adapter<MTGSetViewHolder> {

    public interface Listener {
        void onClickDeleteButton(int position);
    }

    // FOR COMMUNICATION
    private final Listener callback;

    private List<MTGSet> MTGSets;
    private RequestManager glide;

    public MTGSetAdapter(List<MTGSet> MTGSets, RequestManager glide, Listener callback) {
        this.MTGSets = MTGSets;
        this.glide = glide;
        this.callback = callback;
    }

    @Override
    public MTGSetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_sets_item, parent, false);

        return new MTGSetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MTGSetViewHolder viewHolder, int position) {
        viewHolder.updateWithMTGSet(this.MTGSets.get(position));
    }

    @Override
    public int getItemCount() {
        return this.MTGSets.size();
    }

    public MTGSet getMTGSet(int position){
        return this.MTGSets.get(position);
    }
}