package com.dangxy.androidpractice;

/**
 * @author dangxueyi
 * @description
 * @date 2018/2/24
 */

public class Basic {

    private String name;

    private int age;


    @Override
    public int hashCode() {
        return name.hashCode()+age*33;
    }
}
