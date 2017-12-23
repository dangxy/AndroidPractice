package com.dangxy.androidpractice.api;

import com.dangxy.handlerdemo.entity.CommonEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/13
 */

public interface GankService {
    /**
       获取数据
     * @return
             */
    @GET("data/CommonEntity/{size}/{page}")
    Call<CommonEntity> getListData(@Path("size") String size, @Path("page") String page);

}
