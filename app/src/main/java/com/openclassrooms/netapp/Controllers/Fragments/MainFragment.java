package com.openclassrooms.netapp.Controllers.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.openclassrooms.netapp.Controllers.Models.MTGSet;
import com.openclassrooms.netapp.Controllers.Models.MTGSetList;
import com.openclassrooms.netapp.Controllers.Utils.ScryfallStreams;
import com.openclassrooms.netapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    // FOR DESIGN
    @BindView(R.id.fragment_main_textview) TextView textView;

    //FOR DATA
    private Disposable disposable;

    public MainFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.disposeWhenDestroy();
    }

    // -----------------
    // ACTIONS
    // -----------------

    @OnClick(R.id.fragment_main_button)
    public void submit(View view) {
        // 2 - Call the stream
        this.executeHttpRequestGetListOfMTGSets();
    }

    // -------------------
    // HTTP (RxJAVA)
    // -------------------

    private void executeHttpRequestGetListOfMTGSets(){
        this.updateUIWhenStartingHTTPRequest();
        this.disposable = ScryfallStreams.streamFetchListMTGSet().subscribeWith(new DisposableObserver<MTGSetList>() {
            @Override
            public void onNext(MTGSetList mtgSetList) {
                Log.e("TAG","On Next");
                updateUIWithListOfMtgSet(mtgSetList);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("TAG","On Error"+Log.getStackTraceString(e));
            }

            @Override
            public void onComplete() {
                Log.e("TAG","On Complete !!");
            }
        });
    }

    private void executeHttpRequestGetOfMTGSet(){
        this.updateUIWhenStartingHTTPRequest();
        this.disposable = ScryfallStreams.streamFetchMTGSet("c19").subscribeWith(new DisposableObserver<MTGSet>() {
            @Override
            public void onNext(MTGSet set) {
                Log.e("TAG","On Next");
                updateUIWithMtgSet(set);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("TAG","On Error"+Log.getStackTraceString(e));
            }

            @Override
            public void onComplete() {
                Log.e("TAG","On Complete !!");
            }
        });
    }

    private void disposeWhenDestroy(){
        if (this.disposable != null && !this.disposable.isDisposed()) this.disposable.dispose();
    }

    // -------------------
    // UPDATE UI
    // -------------------

    private void updateUIWhenStartingHTTPRequest(){
        this.textView.setText("Downloading...");
    }

    private void updateUIWhenStopingHTTPRequest(String response){
        this.textView.setText(response);
    }

    private void updateUIWithListOfMtgSet(MTGSetList mtgSetList){
        StringBuilder stringBuilder = new StringBuilder();
        for (MTGSet mtgSet : mtgSetList.getData()){
            stringBuilder.append(" - " + mtgSet.getName() + "\n");
        }
        updateUIWhenStopingHTTPRequest(stringBuilder.toString());
    }

    private void updateUIWithMtgSet(MTGSet mtgSet){
        updateUIWhenStopingHTTPRequest("Le Set est " + mtgSet.getName()+" du bloc " + mtgSet.getBlock()+".");
    }
}
