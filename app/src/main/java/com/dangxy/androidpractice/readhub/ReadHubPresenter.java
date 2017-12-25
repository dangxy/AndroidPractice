package com.dangxy.androidpractice.readhub;

import android.support.v4.widget.SwipeRefreshLayout;

import com.dangxy.androidpractice.AppApplication;
import com.dangxy.androidpractice.api.RetrofitReadhub;
import com.dangxy.androidpractice.api.RxReadhubService;
import com.dangxy.androidpractice.base.IBaseNewPresenter;
import com.dangxy.androidpractice.entity.TopicRsp;
import com.dangxy.androidpractice.utils.MLog;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/24
 */

public class ReadHubPresenter implements IBaseNewPresenter, SwipeRefreshLayout.OnRefreshListener {


    private ReadHubView readHubView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private boolean isRefresh;

    public ReadHubPresenter(ReadHubView readHubView) {
        this.readHubView = readHubView;
    }

    public void setRefresh(SwipeRefreshLayout swipeRefreshLayout) {
        this.mSwipeRefreshLayout = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(this);

    }

    @Override
    public void getData() {

        final RxReadhubService readhubService = new RetrofitReadhub().newInstance(AppApplication.getContext()).create(RxReadhubService.class);

        readhubService.listTopicNews("", 15)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        readHubView.showLoading();
                          MLog.e("DANG","show");
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TopicRsp>() {
                    @Override
                    public void accept(TopicRsp topicRsp) throws Exception {
                        if (isRefresh) {
                            mSwipeRefreshLayout.setRefreshing(false);
                            isRefresh = true;
                            readHubView.setRefresh(topicRsp.getData());
                        } else {
                            readHubView.getData(topicRsp.getData());
                        }
                        readHubView.hideLoading();
                    }
                });

    }

    @Override
    public void onRefresh() {
        getData();
        isRefresh = true;
    }
}
