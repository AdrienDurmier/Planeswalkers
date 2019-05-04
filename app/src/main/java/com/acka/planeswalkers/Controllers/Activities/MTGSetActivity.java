package com.acka.planeswalkers.Controllers.Activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.acka.planeswalkers.Controllers.Fragments.MTGSetFragment;
import com.acka.planeswalkers.R;

public class MTGSetActivity extends AppCompatActivity {

    private MTGSetFragment setFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mtgset);
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

        setFragment = (MTGSetFragment) getSupportFragmentManager().findFragmentById(R.id.activity_mtgset_frame_layout);

        if (setFragment == null) {
            setFragment = new MTGSetFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_mtgset_frame_layout, setFragment)
                    .commit();
        }
    }
}
