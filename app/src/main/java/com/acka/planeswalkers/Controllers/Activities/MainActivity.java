package com.acka.planeswalkers.Controllers.Activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.acka.planeswalkers.Adapters.PageAdapter;
import com.acka.planeswalkers.Controllers.Fragments.TabCardFragment;
import com.acka.planeswalkers.Controllers.Fragments.TabSetFragment;
import com.acka.planeswalkers.Models.MTGCard;
import com.acka.planeswalkers.Models.MTGSet;
import com.acka.planeswalkers.R;

public class MainActivity extends AppCompatActivity implements TabCardFragment.MyItemClickListener, TabSetFragment.MyItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.configureToolbar();
        this.configureViewPagerAndTabs();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    private void configureToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_activity_main_params:
                Toast.makeText(this, "todo: moteur de recherche", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_activity_main_search:
                Toast.makeText(this, "todo: recherche", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // -------------------
    // CONFIGURATION
    // -------------------

    private void configureViewPagerAndTabs(){
        ViewPager pager = (ViewPager)findViewById(R.id.activity_main_viewpager);
        pager.setAdapter(new PageAdapter(getSupportFragmentManager()));
        TabLayout tabs= (TabLayout)findViewById(R.id.activity_main_tabs);
        tabs.setupWithViewPager(pager);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    /**
     * Lors du clic sur un set
     */
    @Override
    public void onItemClicked(MTGSet mtgSet) {
        startActivity(new Intent(this, MTGSetActivity.class).putExtra("code", mtgSet.getCode()));
    }

    /**
     * Lors du clic sur une card
     */
    @Override
    public void onItemClicked(MTGCard mtgCard) {
        startActivity(new Intent(this, MTGCardActivity.class).putExtra("uuid", mtgCard.getId()));
    }

}