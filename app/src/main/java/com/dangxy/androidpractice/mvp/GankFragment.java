package com.dangxy.androidpractice.mvp;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dangxy.androidpractice.AppApplication;
import com.dangxy.androidpractice.R;
import com.dangxy.androidpractice.base.BaseLazyFragment;
import com.dangxy.androidpractice.entity.CommonEntity;
import com.dangxy.androidpractice.fragment.GankListAdapter;
import com.dangxy.androidpractice.utils.LoadMoreDelegate;
import com.dangxy.androidpractice.utils.MLog;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import butterknife.BindView;

/**
 * @author dangxy99
 * @description 描述
 * @date 2017/12/24
 */

public class GankFragment extends BaseLazyFragment implements GankView, SwipeRefreshLayout.OnRefreshListener, LoadMoreDelegate.LoadMoreSubject {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    private GankPresenter gankPresenter;
    private GankListAdapter gankListAdapter;
    private List<CommonEntity.ResultsBean> listResults = new ArrayList<>();
    private LoadMoreDelegate loadMoreDelegate;
    private AtomicInteger loadingCount;

    public GankFragment() {
    }


    @Override
    protected void loadData() {
        gankPresenter.getData();

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_gank;
    }

    @Override
    protected void initViews() {
        gankPresenter = new GankPresenter(this);
        //recyclerView.setLayoutManager((new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AppApplication.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        refresh.setOnRefreshListener(this);
        loadMoreDelegate = new LoadMoreDelegate(this);
        loadMoreDelegate.attach(recyclerView);
        loadingCount = new AtomicInteger(0);

    }


    @Override
    public void getCommonEntity(CommonEntity commonEntity) {
        listResults.addAll(commonEntity.getResults());
        gankListAdapter = new GankListAdapter(mContext, listResults);
        recyclerView.setAdapter(gankListAdapter);
    }

    @Override
    public void onRefresh() {
        gankPresenter.refresh(refresh);
    }

    @Override
    public void getRefreshDate(CommonEntity commonEntity) {
        gankListAdapter.refresh(commonEntity.getResults());
    }

    @Override
    public boolean isLoading() {
        return loadingCount.get() > 0;
    }

    @Override
    public void onLoadMore() {
        MLog.e("DANG", "加载更多");
        notifyLoadingStarted();
        gankPresenter.loadMoreData();
    }

    @Override
    public void getLoadMoreData(CommonEntity commonEntity) {
        notifyLoadingFinished();
        gankListAdapter.loadMore(commonEntity.getResults());
    }

    public void notifyLoadingStarted() {

        loadingCount.getAndIncrement();
    }


    public void notifyLoadingFinished() {

        loadingCount.decrementAndGet();
    }
}
