package com.dangxy.androidpractice.entity;

import java.util.List;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/13
 */

public class NewListEntity {
    private List<NewsEntity> data;
    private int pageSize;
    private int totalItems;
    private int totalPages;

    public List<NewsEntity> getData() {
        return data;
    }

    public void setData(List<NewsEntity> data) {
        this.data = data;
    }

    public int getPageSize() {
        return pageSize;
    }
}
