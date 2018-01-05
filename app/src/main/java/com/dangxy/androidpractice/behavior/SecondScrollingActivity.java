package com.dangxy.androidpractice.behavior;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.dangxy.androidpractice.R;
import com.dangxy.androidpractice.fragment.GankAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondScrollingActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.recyclerView)
    ViewPager recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_scrolling);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        GankAdapter gankAdapter = new GankAdapter(getSupportFragmentManager());
        recyclerView.setOffscreenPageLimit(3);
        recyclerView.setAdapter(gankAdapter);
        tabLayout.setupWithViewPager(recyclerView);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabsFromPagerAdapter(gankAdapter);


    }
}
