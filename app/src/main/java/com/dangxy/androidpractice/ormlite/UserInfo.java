package com.dangxy.androidpractice.ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @author dangxueyi
 * @description
 * @date 2018/1/16
 */
@DatabaseTable(tableName = "tb_user")
public class UserInfo {
    @DatabaseField(generatedId = true)
    private int  id;
    @DatabaseField(columnName = "username")
    private String userName;
    @DatabaseField (columnName = "password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserInfo() {
    }
}
