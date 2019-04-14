package com.acka.planeswalkers.Controllers.Views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.RequestManager;
import com.acka.planeswalkers.Controllers.Models.MTGCard;
import com.acka.planeswalkers.R;

import java.util.List;

public class MTGCardAdapter extends RecyclerView.Adapter<MTGCardViewHolder> {

        private List<MTGCard> mtgCards;
        private RequestManager glide;

        public MTGCardAdapter(List<MTGCard> MTGCards, RequestManager glide) {
            this.mtgCards = MTGCards;
            this.glide = glide;
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
    }