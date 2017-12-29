package com.dangxy.androidpractice.custom.view;

/**
 * Created by ${kissfoot} on 2017/11/29.
 */

public class Data {

    private String name;
    private int color;
    private float value;

    public Data(String name, float value, int color) {
        this.name = name;
        this.color = color;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
