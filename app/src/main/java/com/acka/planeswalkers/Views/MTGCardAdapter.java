package com.acka.planeswalkers.Views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.RequestManager;
import com.acka.planeswalkers.Models.MTGCard;
import com.acka.planeswalkers.R;

import java.util.List;

public class MTGCardAdapter extends RecyclerView.Adapter<MTGCardViewHolder> {

    public interface Listener {
        void onClickDeleteButton(int position);
    }

    // FOR COMMUNICATION
    private final Listener callback;

    private List<MTGCard> mtgCards;
    private RequestManager glide;

    public MTGCardAdapter(List<MTGCard> MTGCards, RequestManager glide, Listener callback) {
        this.mtgCards = MTGCards;
        this.glide = glide;
        this.callback = callback;
    }

    @Override
    public MTGCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_main_item, parent, false);

        return new MTGCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MTGCardViewHolder viewHolder, int position) {
        viewHolder.updateWithMTGCard(this.mtgCards.get(position), this.glide);
    }

    @Override
    public int getItemCount() {
        return this.mtgCards.size();
    }

    public MTGCard getMTGCard(int position){
        return this.mtgCards.get(position);
    }
}