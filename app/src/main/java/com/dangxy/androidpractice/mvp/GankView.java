package com.dangxy.androidpractice.mvp;

import com.dangxy.androidpractice.base.IBaseView;
import com.dangxy.androidpractice.entity.CommonEntity;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/24
 */

public interface GankView extends IBaseView {

    void getCommonEntity(CommonEntity commonEntity);

    void getRefreshDate(CommonEntity commonEntity);

    void getLoadMoreData(CommonEntity commonEntity);
}
