package com.dangxy.androidpractice.mvp;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.dangxy.androidpractice.AppApplication;
import com.dangxy.androidpractice.api.RetrofitGank;
import com.dangxy.androidpractice.api.RxGankService;
import com.dangxy.androidpractice.base.IBaseNewPresenter;
import com.dangxy.androidpractice.entity.CommonEntity;
import com.dangxy.androidpractice.utils.LoadMoreDelegate;
import com.dangxy.androidpractice.utils.MLog;

import java.util.concurrent.atomic.AtomicInteger;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/24
 */

public class GankNewPresenter implements IBaseNewPresenter, LoadMoreDelegate.LoadMoreSubject, SwipeRefreshLayout.OnRefreshListener {


    private final RxGankService rxGankService;
    private GankNewView gankView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private boolean isRefresh;
    private RecyclerView mRecyclerView;
    private LoadMoreDelegate loadMoreDelegate;
    private AtomicInteger loadingCount;
    private int page;
    private String pageSize;

    public GankNewPresenter(GankNewView gankView) {
        this.gankView = gankView;
        rxGankService = new RetrofitGank().newInstance(AppApplication.getContext()).create(RxGankService.class);
    }

    public void setRefresh(SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView) {
        this.mSwipeRefreshLayout = swipeRefreshLayout;
        this.mRecyclerView = recyclerView;
        mSwipeRefreshLayout.setOnRefreshListener(this);
        loadMoreDelegate = new LoadMoreDelegate(this);
        loadMoreDelegate.attach(mRecyclerView);
        loadingCount = new AtomicInteger(0);
        //pageSize = MathUtils.getRandomIntNum(5, 10) + "";
        //page = MathUtils.getRandomIntNum(1, 15);
        page = 1;
        pageSize = 15 + "";

    }

    @Override
    public void getData() {
        MLog.e("DANG", page + "");
        rxGankService.getWelfareListData(pageSize + "", page + "")
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        notifyLoadingStarted();
                        if (!isRefresh && !isLoading()) {
                            gankView.showLoading();
                        }
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CommonEntity>() {
                    @Override
                    public void accept(CommonEntity commonEntity) throws Exception {
                        notifyLoadingFinished();
                        if (isRefresh) {
                            mSwipeRefreshLayout.setRefreshing(false);
                            isRefresh = false;
                            gankView.setRefresh(commonEntity);
                        } else {
                            gankView.hideLoading();
                            gankView.getCommonEntity(commonEntity, page);

                        }

                    }
                });


    }

    @Override
    public boolean isLoading() {
        return loadingCount.get() > 0;
    }

    @Override
    public void onLoadMore() {
        page++;
        getData();
    }

    public void notifyLoadingStarted() {

        loadingCount.getAndIncrement();
    }


    public void notifyLoadingFinished() {

        loadingCount.decrementAndGet();
    }

    @Override
    public void onRefresh() {
        page = 1;
        isRefresh = true;
        getData();
    }
}
