package com.openclassrooms.netapp.Controllers.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.openclassrooms.netapp.Controllers.Models.MTGSet;
import com.openclassrooms.netapp.Controllers.Utils.MyHttpURLConnection;
import com.openclassrooms.netapp.Controllers.Utils.NetworkAsyncTask;
import com.openclassrooms.netapp.Controllers.Utils.ScryfallCalls;
import com.openclassrooms.netapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements NetworkAsyncTask.Listeners, ScryfallCalls.Callbacks {

    // FOR DESIGN
    @BindView(R.id.fragment_main_textview) TextView textView;

    public MainFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    // -----------------
    // ACTIONS
    // -----------------

    @OnClick(R.id.fragment_main_button)
    public void submit(View view) {
        this.executeHttpRequest();
    }

    // -----------------
    // HTTP REQUEST
    // -----------------

    private void executeHttpRequestWithRetrofit(){
        this.updateUIWhenStartingHTTPRequest();
        ScryfallCalls.fetchSets(this);
    }

    @Override
    public void onResponse(@Nullable List<MTGSet> sets){
        if(sets != null) this.updateUIWithListOfSets(sets);
    }

    @Override
    public void onFailure(){
        this.updateUIWhenStopingHTTPRequest("Oh oh! On dirait qu'il y a un problème");
    }

    private void executeHttpRequest(){
        new NetworkAsyncTask(this).execute("https://api.scryfall.com/sets");
    }

    @Override
    public void onPreExecute(){
        this.updateUIWhenStartingHTTPRequest();
    }

    @Override
    public void doInBackground(){
    }

    @Override
    public void onPostExecute(String json){
        this.updateUIWhenStopingHTTPRequest(json);
    }

    // -----------------
    // UPDATE UI
    // -----------------

    private void updateUIWhenStartingHTTPRequest(){
        this.textView.setText("Downloading");
    }

    private void updateUIWhenStopingHTTPRequest(String response){
        this.textView.setText(response);
    }

    private void updateUIWithListOfSets(List<MTGSet> sets){
        StringBuilder stringBuilder = new StringBuilder();
        for(MTGSet set : sets){
            stringBuilder.append("-" + set.getData() + "\n"); // <- getData() ????????????????????????????????
        }
        updateUIWhenStopingHTTPRequest(stringBuilder.toString());
    }

}
