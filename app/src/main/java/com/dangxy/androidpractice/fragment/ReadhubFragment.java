package com.dangxy.androidpractice.fragment;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.dangxy.androidpractice.AppApplication;
import com.dangxy.androidpractice.R;
import com.dangxy.androidpractice.api.RetrofitGank;
import com.dangxy.androidpractice.api.RxGankService;
import com.dangxy.androidpractice.base.BaseLazyFragment;
import com.dangxy.androidpractice.entity.CommonEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * @author dangxy99
 * @description 描述
 * @date 2017/12/23
 */
public class ReadhubFragment extends BaseLazyFragment {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    private RxGankService rxGankService;
    private GankListAdapter gankListAdapter;
    private List<CommonEntity.ResultsBean> listResults =new ArrayList<>();

    public static ReadhubFragment newInstance() {
        ReadhubFragment fragment = new ReadhubFragment();
        return fragment;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_reabhub;
    }

    @Override
    protected void loadData() {

        String pageSize = getRandomNum(35, 60) + "";
        String page = getRandomNum(1, 15) + "";
        rxGankService.getWelfareListData(pageSize, page)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        showLoading();
                    }
                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CommonEntity>() {
                    @Override
                    public void accept(CommonEntity commonEntity) throws Exception {
                        hideLoading();
                        if (refresh.isRefreshing()) {
                            refresh.setRefreshing(false);
                        }
                        if (gankListAdapter == null) {
                            listResults.addAll(commonEntity.getResults());
                            gankListAdapter = new GankListAdapter(mContext, listResults);
                            recyclerView.setAdapter(gankListAdapter);
                        } else {
                           gankListAdapter.refresh(commonEntity.getResults());

                        }

                    }
                });

    }

    @Override
    protected void initViews() {
        refresh.setColorSchemeResources(R.color.color_d90051);
        rxGankService = new RetrofitGank().newInstance(AppApplication.getContext()).create(RxGankService.class);
        recyclerView.setLayoutManager((new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)));
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });

    }

    public static int getRandomNum(int min, int max) {
        Random rdm = new Random();
        return rdm.nextInt(max - min + 1) + min;
    }

}
