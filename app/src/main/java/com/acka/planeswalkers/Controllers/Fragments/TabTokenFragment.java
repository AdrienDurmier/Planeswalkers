package com.acka.planeswalkers.Controllers.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acka.planeswalkers.R;

public class TabTokenFragment extends Fragment {

    public static TabTokenFragment newInstance() {
        return (new TabTokenFragment());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_token_fragment, container, false);
    }
}
