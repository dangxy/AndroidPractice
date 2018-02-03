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


        Test<? > test = new Test<>(1);
        Test<? extends Class> test1 = new Test<>(GerericsTest.class);

        Container<String, Integer> container1 = new Container<>("1", 1);


        Container<String, String> container2 = new Container<>("1", "1");

        container1.getK();

        container1.getV();
        container2.getV();

        test.getData();

        Singleton.getInstance();




    }


    public class Test<T> {

        private T data;


        public Test(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
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

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    public class Container<K, V> {
        private K k;
        private V v;

        public Container(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public K getK() {
            return k;
        }

        public void setK(K k) {
            this.k = k;
        }

        public V getV() {
            return v;
        }

        public void setV(V v) {
            this.v = v;
        }
    }

    public interface GernericsInter<T> {
        /**
         * 获取数据
         *
         * @return
         */
        T getData();
    }
}
