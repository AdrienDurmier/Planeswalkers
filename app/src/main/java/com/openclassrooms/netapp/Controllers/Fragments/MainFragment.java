package com.openclassrooms.netapp.Controllers.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.openclassrooms.netapp.Controllers.Models.MTGDatum;
import com.openclassrooms.netapp.Controllers.Models.MTGSet;
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
        this.executeSecondHttpRequestWithRetrofit();
    }

    // -------------------
    // HTTP (RxJAVA)
    // -------------------

    // 1 - Execute our Stream
    private void executeHttpRequestWithRetrofit(){
        // 1.1 - Update UI
        this.updateUIWhenStartingHTTPRequest();
        // 1.2 - Execute the stream subscribing to Observable defined inside GithubStream
        this.disposable = ScryfallStreams.streamFetchSets().subscribeWith(new DisposableObserver<List<MTGSet>>() {
            @Override
            public void onNext(List<MTGSet> sets) {
                Log.e("TAG","On Next");
                // 1.3 - Update UI with list of users
                updateUIWithListOfSets(sets);
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
    private void executeSecondHttpRequestWithRetrofit(){
        this.updateUIWhenStartingHTTPRequest();
        this.disposable = ScryfallStreams.streamFetchSetDatum("mmq").subscribeWith(new DisposableObserver<MTGDatum>() {
            @Override
            public void onNext(MTGDatum datum) {
                Log.e("TAG","On Next");
                updateUIWithSetDatum(datum);
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

    private void updateUIWithListOfSets(List<MTGSet> sets){
        StringBuilder stringBuilder = new StringBuilder();
        for (MTGSet set : sets){
            stringBuilder.append("-"+set.getData()+"\n");
        }
        updateUIWhenStopingHTTPRequest(stringBuilder.toString());
    }

    private void updateUIWithSetDatum(MTGDatum datum){
        updateUIWhenStopingHTTPRequest("Le Set est"+datum.getName()+" du bloc "+datum.getBlock()+".");
    }
}
