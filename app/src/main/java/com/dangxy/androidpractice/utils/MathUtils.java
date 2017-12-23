package com.dangxy.androidpractice.utils;

import java.util.Random;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/24
 */

public class MathUtils {
    /**
     * 生成两个数之间的随机数返回int
     * @param min
     * @param max
     * @return
     */
    public static int getRandomIntNum(int min, int max) {
        Random rdm = new Random();
        return rdm.nextInt(max - min + 1) + min;
    }

    /**
     * 生成两个数直接的随机数返回double
     * @param min
     * @param max
     * @return
     */
    public static double getRandomDoubleNum(int min,int max){
        return Math.round(Math.random()*(max-min))+min;
    }
}
