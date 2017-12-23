package com.dangxy.androidpractice.realm;

import io.realm.RealmObject;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/23
 */

public class Dog extends RealmObject {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
