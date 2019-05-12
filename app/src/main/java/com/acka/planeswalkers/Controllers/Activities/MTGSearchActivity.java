package com.acka.planeswalkers.Controllers.Activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.acka.planeswalkers.Controllers.Fragments.MTGSearchFragment;
import com.acka.planeswalkers.R;

public class MTGSearchActivity extends AppCompatActivity {

    private MTGSearchFragment searchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mtgsearch);
        this.configureToolbar();
        this.configureAndShowDetailFragment();
    }

    private void configureToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    // -------------------
    // CONFIGURATION
    // -------------------

    private void configureAndShowDetailFragment(){

        searchFragment = (MTGSearchFragment) getSupportFragmentManager().findFragmentById(R.id.activity_mtgsearch_frame_layout);

        if (searchFragment == null) {
            searchFragment = new MTGSearchFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_mtgsearch_frame_layout, searchFragment)
                    .commit();
        }
    }
}
