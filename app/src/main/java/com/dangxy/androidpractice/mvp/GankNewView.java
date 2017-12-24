package com.dangxy.androidpractice.mvp;

import com.dangxy.androidpractice.base.IBaseView;
import com.dangxy.androidpractice.entity.CommonEntity;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/24
 */

public interface GankNewView extends IBaseView {


    void getCommonEntity(CommonEntity commonEntity, int page);

    void setRefresh(CommonEntity commonEntity);
}
