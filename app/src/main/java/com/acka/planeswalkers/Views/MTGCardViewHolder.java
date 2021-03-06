package com.acka.planeswalkers.Views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.acka.planeswalkers.Models.MTGCard;
import com.acka.planeswalkers.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MTGCardViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.fragment_cards_item_title) TextView textViewTitle;
    @BindView(R.id.fragment_cards_item_type_line) TextView textViewTypeLine;
    @BindView(R.id.fragment_cards_item_image) ImageView imageView;

    public MTGCardViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void updateWithMTGCard(MTGCard mtgCard, RequestManager glide){
        this.textViewTitle.setText(mtgCard.getName());
        this.textViewTypeLine.setText(mtgCard.getTypeLine());
        if(mtgCard.getImageUris() != null){
            if(mtgCard.getImageUris().getArtCrop() != null){
                glide.load(mtgCard.getImageUris().getArtCrop()).apply(RequestOptions.centerCropTransform()).into(imageView);
            }
        }
    }
}