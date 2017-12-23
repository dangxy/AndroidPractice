package com.dangxy.androidpractice.entity;


import com.dangxy.androidpractice.utils.TextUtils;

import java.util.ArrayList;

/**
 * @desc Created by erichua on 15/05/2017.
 */

public class Topic {
    private String id;
    private String title;
    private String summary;
    private ArrayList<NewsEntity> newsArray;
    private ArrayList<NewsEntity> weiboArray;
    private ArrayList<NewsEntity> wechatArray;
    private ArrayList<NewsEntity> relatedTopicArray;
    private String publishUserId;
    private String order;
    private String publishDate;
    private String createdAt;
    private String updatedAt;

    public String getId() {
        return TextUtils.getSafeString(id);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return TextUtils.getSafeString(title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return TextUtils.getSafeString(summary);
    }

    public ArrayList<NewsEntity> getNewsArray() {
        return newsArray;
    }

    public String getOrder() {
        return TextUtils.getSafeString(order);
    }

}
