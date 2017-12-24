package com.dangxy.androidpractice.readhub;

import com.dangxy.androidpractice.AppApplication;
import com.dangxy.androidpractice.api.RetrofitReadhub;
import com.dangxy.androidpractice.api.RxReadhubService;
import com.dangxy.androidpractice.base.IBaseNewPresenter;
import com.dangxy.androidpractice.entity.TopicRsp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/24
 */

public class ReadHubPresenter implements IBaseNewPresenter {


    private ReadHubView readHubView;

    public ReadHubPresenter(ReadHubView readHubView) {
        this.readHubView = readHubView;
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
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TopicRsp>() {
                    @Override
                    public void accept(TopicRsp topicRsp) throws Exception {
                        readHubView.hideLoading();
                        readHubView.getData(topicRsp.getData());
                    }
                });

    }
}
