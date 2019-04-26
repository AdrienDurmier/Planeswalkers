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
public class TabSetFragment extends Fragment {

    public static TabSetFragment newInstance() {
        return (new TabSetFragment());
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_set_fragment, container, false);
    }

}
