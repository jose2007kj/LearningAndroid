package com.example.jose2007kj.learningandroid.jose2007kj;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        //appBarLayout.
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new NamesFragment(), "Player Names");
        adapter.addFragment(new PlayersFragment(), "Players Images");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
