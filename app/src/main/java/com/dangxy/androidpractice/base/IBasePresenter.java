package com.dangxy.androidpractice.base;

import android.support.v4.widget.SwipeRefreshLayout;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/24
 */

public interface IBasePresenter {
    /**
     * 从网路中获取数据
     */
    void getData();

    /**
     * 刷新数据
     * @param swipeRefreshLayout
     */
    void refresh(SwipeRefreshLayout swipeRefreshLayout);

    /**
     * 加载更多
     */
     void loadMoreData();
}
