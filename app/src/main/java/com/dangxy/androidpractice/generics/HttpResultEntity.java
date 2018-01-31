package com.dangxy.androidpractice.generics;

import rx.functions.Func1;

/**
 * @author dangxueyi
 * @description
 * @date 2018/1/31
 */

public class HttpResultEntity<T> implements Func1<GernericsEntity<T>,T> {

    @Override
    public T call(GernericsEntity<T> gernericsEntity) {
        if(gernericsEntity.getCode()!=1){
            try {
                throw new Exception(gernericsEntity.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return gernericsEntity.getData();
    }
}
