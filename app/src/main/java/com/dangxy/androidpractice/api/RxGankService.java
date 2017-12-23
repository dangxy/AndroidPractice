package com.dangxy.androidpractice.api;


import com.dangxy.androidpractice.entity.CommonEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/13
 */

public interface RxGankService {
    /**
     * RX获取gank的Android数据
     * @return
     */
    @GET("data/Android/{size}/{page}")
    Observable <CommonEntity> getListData(@Path("size") String size, @Path("page") String page);
    /**
     * RX获取gank的福利数据
     * @return
     */
    @GET("data/福利/{size}/{page}")
    Observable <CommonEntity> getWelfareListData(@Path("size") String size, @Path("page") String page);
}
