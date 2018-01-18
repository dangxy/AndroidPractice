package com.dangxy.androidpractice.generics;

import android.app.Activity;
import android.os.Bundle;

import com.dangxy.androidpractice.R;

/**
 * @author dangxy99
 * @description 描述
 * @date 2018/1/17
 */
public class GenericsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generics);

        Test<? extends Number> test = new Test<>(1);





    }


    public class Test<T> {

        private T data;


        public Test(T data) {
            this.data = data;
        }
    }

    public static class Singleton {
        private static Singleton instance;

        private Singleton() {

        }

        public static synchronized Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;

        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);



    }
}
