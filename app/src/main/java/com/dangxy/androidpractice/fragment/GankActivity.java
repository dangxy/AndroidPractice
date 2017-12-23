package com.dangxy.androidpractice.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.dangxy.androidpractice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author dangxy99
 * @description 描述
 * @date 2017/12/24
 */
public class GankActivity extends AppCompatActivity {

    @BindView(R.id.tl_gank_list)
    TabLayout tlGankList;
    @BindView(R.id.vp_gank_list)
    ViewPager vpGankList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank);
        ButterKnife.bind(this);
        GankAdapter readhubAdapter = new GankAdapter(getSupportFragmentManager());
        vpGankList.setOffscreenPageLimit(6);
        vpGankList.setAdapter(readhubAdapter);
        tlGankList.setupWithViewPager(vpGankList);
        tlGankList.setTabsFromPagerAdapter(readhubAdapter);
    }
}
