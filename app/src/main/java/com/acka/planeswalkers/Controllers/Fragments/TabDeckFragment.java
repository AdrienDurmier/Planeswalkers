package com.acka.planeswalkers.Controllers.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acka.planeswalkers.R;

public class TabDeckFragment extends Fragment {

    public static TabDeckFragment newInstance() {
        return (new TabDeckFragment());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_deck_fragment, container, false);
    }
}
