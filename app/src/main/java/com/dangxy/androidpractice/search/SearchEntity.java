package com.dangxy.androidpractice.search;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @author dangxueyi
 * @description
 * @date 2018/1/17
 */
@DatabaseTable(tableName = "tb_search")
public class SearchEntity {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "key")
    private String key;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
