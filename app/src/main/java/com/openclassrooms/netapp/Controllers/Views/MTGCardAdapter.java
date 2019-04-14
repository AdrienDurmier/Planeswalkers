package com.openclassrooms.netapp.Controllers.Views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.netapp.Controllers.Models.MTGCard;
import com.openclassrooms.netapp.R;

import java.util.List;

public class MTGCardAdapter extends RecyclerView.Adapter<MTGCardViewHolder> {

        // FOR DATA
        private List<MTGCard> mtgCards;

        // CONSTRUCTOR
        public MTGCardAdapter(List<MTGCard> MTGCards) {
            this.mtgCards = MTGCards;
        }

        @Override
        public MTGCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.fragment_main_item, parent, false);

            return new MTGCardViewHolder(view);
        }

        // UPDATE VIEW HOLDER WITH A MTGCard
        @Override
        public void onBindViewHolder(MTGCardViewHolder viewHolder, int position) {
            viewHolder.updateWithMTGCard(this.mtgCards.get(position));
        }

        // RETURN THE TOTAL COUNT OF ITEMS IN THE LIST
        @Override
        public int getItemCount() {
            return this.mtgCards.size();
        }
    }