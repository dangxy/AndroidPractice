package com.dangxy.androidpractice.api;


import com.dangxy.androidpractice.entity.NewListEntity;
import com.dangxy.androidpractice.entity.TopicRsp;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/13
 */

public interface RxReadhubService {
    /**
     * 获取新闻信息
     * @param lastCursor
     * @param pageSize
     * @return
     */
    @GET("news")
    Call<NewListEntity> listNews(@Query("lastCursor") String lastCursor, @Query("pageSize") int pageSize);
    /**
     * 获取热门话题
     * @param lastCursor
     * @param pageSize
     * @return
     */
    @GET("topic")
    Observable<TopicRsp> listTopicNews(@Query("lastCursor") String lastCursor, @Query("pageSize") int pageSize);
    /**
     * 获取开发者头条
     * @param lastCursor
     * @param pageSize
     * @return
     */
    @GET("technews")
    Call<NewListEntity> listTechNews(@Query("lastCursor") String lastCursor, @Query("pageSize") int pageSize);
}
