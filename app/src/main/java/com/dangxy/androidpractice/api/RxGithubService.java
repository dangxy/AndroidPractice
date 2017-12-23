package com.dangxy.androidpractice.api;

import com.dangxy.handlerdemo.entity.RepoEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/13
 */

public interface RxGithubService {
    /**
     * RX获取仓库
     * @param user
     * @return
     */
    @GET("users/{user}/repos")
    Observable<List<RepoEntity>> listRepos(@Path("user") String user);

    @GET("users/{user}/starred")
    Observable<List<RepoEntity>> listStarredRepos(@Path("user") String user);
}
