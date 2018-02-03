package com.dangxy.androidpractice;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * @author dangxueyi
 * @description
 * @date 2018/1/31
 */

public class RxBus {

    private final PublishSubject<Object> bus = PublishSubject.create();


    public static RxBus singleton() { return LazyLoad.BUS; }


    public boolean hasObservers() {
        return bus.hasObservers();
    }


    public void post(final Object o) {
        bus.onNext(o);
    }


    public Observable<Object> toObservable() {
        return bus;
    }


    private static class LazyLoad {
        static final RxBus BUS = new RxBus();
    }
}
