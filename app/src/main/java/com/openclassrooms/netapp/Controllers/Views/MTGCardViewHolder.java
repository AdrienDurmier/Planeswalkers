package com.openclassrooms.netapp.Controllers.Views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.openclassrooms.netapp.Controllers.Models.MTGCard;
import com.openclassrooms.netapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MTGCardViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.fragment_main_item_title) TextView textView;

        public MTGCardViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void updateWithMTGCard(MTGCard mtgCard){
            this.textView.setText(mtgCard.getName() + " " + mtgCard.getManaCost());
        }
    }