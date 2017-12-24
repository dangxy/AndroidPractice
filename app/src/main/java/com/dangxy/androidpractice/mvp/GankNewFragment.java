package com.dangxy.androidpractice.mvp;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dangxy.androidpractice.AppApplication;
import com.dangxy.androidpractice.R;
import com.dangxy.androidpractice.base.BaseLazyFragment;
import com.dangxy.androidpractice.entity.CommonEntity;
import com.dangxy.androidpractice.fragment.GankListAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import butterknife.BindView;

/**
 * @author dangxy99
 * @description 描述
 * @date 2017/12/24
 */

public class GankNewFragment extends BaseLazyFragment implements GankNewView {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    private GankNewPresenter gankPresenter;
    private GankListAdapter gankListAdapter;
    private List<CommonEntity.ResultsBean> listResults = new ArrayList<>();

    public GankNewFragment() {
    }


    @Override
    protected void loadData() {
        gankPresenter.setRefresh(refresh,recyclerView);
        gankPresenter.getData();

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_gank;
    }

    @Override
    protected void initViews() {
        gankPresenter = new GankNewPresenter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AppApplication.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

    }


    @Override
    public void getCommonEntity(CommonEntity commonEntity, int page) {
        if (page == 1) {
            listResults.addAll(commonEntity.getResults());
            gankListAdapter = new GankListAdapter(mContext, listResults);
            recyclerView.setAdapter(gankListAdapter);
        } else {
            gankListAdapter.loadMore(commonEntity.getResults());
        }
    }

    @Override
    public void setRefresh(CommonEntity commonEntity) {
        gankListAdapter.refresh(commonEntity.getResults());
    }
}
