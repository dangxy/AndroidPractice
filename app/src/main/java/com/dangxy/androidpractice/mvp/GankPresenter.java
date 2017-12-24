package com.dangxy.androidpractice.mvp;

import android.support.v4.widget.SwipeRefreshLayout;

import com.dangxy.androidpractice.AppApplication;
import com.dangxy.androidpractice.api.RetrofitGank;
import com.dangxy.androidpractice.api.RxGankService;
import com.dangxy.androidpractice.base.IBasePresenter;
import com.dangxy.androidpractice.entity.CommonEntity;
import com.dangxy.androidpractice.utils.MathUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/24
 */

public class GankPresenter implements IBasePresenter {


    private final RxGankService rxGankService;
    private GankView gankView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private boolean isRefresh;
    private boolean isLoading;

    public GankPresenter(GankView gankView) {
        this.gankView = gankView;
        rxGankService = new RetrofitGank().newInstance(AppApplication.getContext()).create(RxGankService.class);
    }

    @Override
    public void getData() {
        String pageSize = MathUtils.getRandomIntNum(35, 60) + "";
        String page = MathUtils.getRandomIntNum(1, 15) + "";
        rxGankService.getWelfareListData(pageSize, page)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (!isRefresh && !isLoading) {
                            gankView.showLoading();
                        }
                    }
                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CommonEntity>() {
                    @Override
                    public void accept(CommonEntity commonEntity) throws Exception {
                        gankView.hideLoading();
                        if (isRefresh) {
                            mSwipeRefreshLayout.setRefreshing(false);
                            isRefresh = false;
                            gankView.getRefreshDate(commonEntity);
                        } else if (isLoading) {
                            gankView.getLoadMoreData(commonEntity);
                        } else {
                            gankView.getCommonEntity(commonEntity);

                        }

                    }
                });


    }

    @Override
    public void refresh(SwipeRefreshLayout swipeRefreshLayout) {
        this.mSwipeRefreshLayout = swipeRefreshLayout;
        getData();
        isRefresh = true;
    }

    @Override
    public void loadMoreData() {
        getData();
        isLoading = true;
    }
}
