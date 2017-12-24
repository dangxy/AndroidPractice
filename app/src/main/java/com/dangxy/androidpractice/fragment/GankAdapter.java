package com.dangxy.androidpractice.fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dangxy.androidpractice.mvp.GankFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/23
 */

public class GankAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private List<String> fragmentTitles;
    private List<String> titleList;

    public GankAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        fragmentTitles = new ArrayList<>();
        titleList = new ArrayList<>();
        titleList.add("福利");
        titleList.add("Android");
        titleList.add("iOS");
        titleList.add("休息视频");
        titleList.add("拓展资源");
        titleList.add("前端");
        titleList.add("ALL");
        initData();
    }

    private void initData() {
        for (String s : titleList) {
            fragmentTitles.add(s);
            ReadhubFragment rxReadhubFragment = new ReadhubFragment();
            GankFragment gankFragment = new GankFragment();
            fragments.add(gankFragment);
        }
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments.size() > 0) {
            return fragments.get(position);
        } else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return fragmentTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (fragmentTitles.size() > 0) {
            return fragmentTitles.get(position);
        } else {
            return null;
        }
    }


}
