package com.acka.planeswalkers.Controllers.Activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.acka.planeswalkers.Controllers.Fragments.MTGCardFragment;
import com.acka.planeswalkers.R;

    public class MTGCardActivity extends AppCompatActivity {

        private MTGCardFragment cardFragment;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_mtgcard);
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

            cardFragment = (MTGCardFragment) getSupportFragmentManager().findFragmentById(R.id.activity_mtgcard_frame_layout);

            if (cardFragment == null) {
                cardFragment = new MTGCardFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.activity_mtgcard_frame_layout, cardFragment)
                        .commit();
            }
        }
    }
