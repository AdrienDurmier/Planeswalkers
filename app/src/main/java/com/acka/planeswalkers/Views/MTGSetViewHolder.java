package com.acka.planeswalkers.Views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.acka.planeswalkers.Models.MTGSet;
import com.acka.planeswalkers.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MTGSetViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.fragment_sets_item_title) TextView textViewTitle;
    @BindView(R.id.fragment_sets_item_block) TextView textViewBlock;

    public MTGSetViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void updateWithMTGSet(MTGSet mtgSet){
        this.textViewTitle.setText(mtgSet.getName());
        this.textViewBlock.setText(mtgSet.getBlock());
    }
}