package com.dangxy.androidpractice.api;

import com.dangxy.handlerdemo.entity.RebaseUserEntity;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/14
 */

public interface RebaseService {
    /**
     * Rebase 注册仓库
     * @param username
     * @param password
     * @param name
     * @param email
     * @param description
     * @return
     */
    @FormUrlEncoded
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @POST("users/")
    Call<RebaseUserEntity> register(@Field("username") String username,
                                    @Field("password") String password,
                                    @Field("name") String name,
                                    @Field("email") String email,
                                    @Field("description") String description
    );
}
