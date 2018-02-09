package com.dangxy.androidpractice.thread;

import java.util.concurrent.Callable;

/**
 * @author dangxueyi
 * @description
 * @date 2018/2/8
 */

public class CallTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello callable";
    }
}

