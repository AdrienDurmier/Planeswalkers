package com.acka.planeswalkers.Controllers.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.acka.planeswalkers.Controllers.Fragments.MainFragment;
import com.acka.planeswalkers.Models.MTGCard;
import com.acka.planeswalkers.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MyItemClickListener {

    private MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.configureAndShowMainFragment();
    }

    // -------------------
    // CONFIGURATION
    // -------------------

    private void configureAndShowMainFragment(){

        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.activity_main_frame_layout);

        if (mainFragment == null) {
            mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_main_frame_layout, mainFragment)
                    .commit();
        }
    }

    /**
     * Lors du clic sur une card
     */
    @Override
    public void onItemClicked(MTGCard mtgCard) {
        startActivity(new Intent(this, MTGCardActivity.class).putExtra("uuid", mtgCard.getId()));
    }
}