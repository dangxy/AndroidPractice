package com.dangxy.androidpractice.api;


import com.dangxy.androidpractice.entity.RepoEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/13
 */

public interface GithubService {
    /**
     * 获取仓库
     * @param user
     * @return
     */
    @GET("users/{user}/repos")
    Call<List<RepoEntity>> listRepos(@Path("user") String user);


}
