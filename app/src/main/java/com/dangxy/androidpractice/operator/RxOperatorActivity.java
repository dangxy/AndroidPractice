package com.dangxy.androidpractice.operator;

import android.view.View;
import android.widget.Button;

import com.dangxy.androidpractice.R;
import com.dangxy.androidpractice.base.BaseActivity;
import com.dangxy.androidpractice.utils.MLog;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author dangxy99
 * @description 描述
 * @date 2017/12/26
 */
public class RxOperatorActivity extends BaseActivity {

    @BindView(R.id.create)
    Button create;
    @BindView(R.id.just)
    Button just;
    @BindView(R.id.fromArray)
    Button fromArray;
    Integer i = 99;
    List<String> list = new ArrayList<>();


    @Override
    protected void initView() {

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_rx_operator;
    }

    @OnClick({R.id.create, R.id.just, R.id.fromArray, R.id.fromIterable, R.id.defer, R.id.time, R.id.interval, R.id.interval_range, R.id.range,
            R.id.map, R.id.flatmap, R.id.concatmap, R.id.merge, R.id.concat,R.id.zip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.create:
                createOperator();
                break;
            case R.id.just:
                justOperator();
                break;
            case R.id.fromArray:
                fromArrayOperator();
                break;
            case R.id.fromIterable:
                fromInterable();
                break;
            case R.id.defer:
                deferOperator();
                break;
            case R.id.time:
                timeOperator();
                break;
            case R.id.interval:
                interavalOpertaor();
                break;
            case R.id.interval_range:
                interavalRangeOpertaor();
                break;
            case R.id.range:
                rangeOperator();
                break;
            case R.id.map:
                mapOperator();
                break;
            case R.id.flatmap:
                flatMapOperator();
                break;
            case R.id.concatmap:
                concatMapOperator();
                break;
            case R.id.merge:
                megreOperator();
                break;
            case R.id.concat:
                concatOperator();
                break;
            case R.id.zip:
                zipOperator();
                break;

            default:
                break;
        }
    }

    private void zipOperator() {
        Observable.zip(Observable.just("1", "2", "3")
                , Observable.just("a", "b", "c"), new BiFunction<String, String, String>() {

                    @Override
                    public String apply(String s, String s2) throws Exception {
                        return s + s2;
                    }
                }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                MLog.e("zip", s);
            }
        });


    }

    private void concatOperator() {
        Observable.concat(Observable.intervalRange(0, 3, 1, 1, TimeUnit.SECONDS),
                Observable.intervalRange(2, 3, 1, 1, TimeUnit.SECONDS))
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        MLog.e("concat", aLong + "");
                    }
                });
    }

    private void megreOperator() {

        Observable.merge(Observable.intervalRange(0, 3, 1, 1, TimeUnit.SECONDS),
                Observable.intervalRange(2, 3, 1, 1, TimeUnit.SECONDS))
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        MLog.e("megre", aLong + "");
                    }
                });


    }

    private void concatMapOperator() {
        Observable.just("1", "2", "3")
                .concatMap(new Function<String, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(String s) throws Exception {
                        return Observable.just(s);
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String string) throws Exception {
                        MLog.e("concat", string);
                    }
                });

    }


    private void flatMapOperator() {
        Observable
                .create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> e) throws Exception {
                        e.onNext("dog");
                        e.onNext("cat");
                        e.onNext("pig");
                        e.onComplete();
                    }
                })
                .flatMap(new Function<String, ObservableSource<List<String>>>() {
                    @Override
                    public ObservableSource<List<String>> apply(String s) throws Exception {
                        list.add(s);
                        return Observable.fromArray(list);
                    }
                })
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> strings) throws Exception {

                        for (String str : strings) {
                            MLog.e("flatmap", str);
                        }
                    }
                });


    }


    private void mapOperator() {

        Observable.just("1", "2", "3")
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) throws Exception {
                        return Integer.parseInt(s);
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                MLog.e("map", (integer + 100) + "");
            }
        });

    }


    private void rangeOperator() {

        Observable.range(100, 10)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        MLog.e("range", integer + "");
                    }
                });
    }

    private void interavalRangeOpertaor() {
        Observable.intervalRange(10, 5, 5, 2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        MLog.e("interavalRangeOpertaor", aLong + "");
                    }
                });
    }

    private void interavalOpertaor() {

        Observable.interval(5, 2, TimeUnit.SECONDS, Schedulers.computation())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        MLog.e("interaval", aLong + "");

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void timeOperator() {

        Observable.timer(5, TimeUnit.SECONDS).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                MLog.e("TIME", aLong + "");
            }
        });


    }

    private void fromInterable() {

        List<String> list = new ArrayList<>();
        list.add("sex");
        list.add("man");
        list.add("woman");
        Observable.fromIterable(list)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        MLog.e("interable", s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void deferOperator() {

        Observable<Integer> observable = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> call() throws Exception {
                return Observable.just(i);
            }
        });

        i = 100;
        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

                MLog.e("defer", integer + "");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    private void fromArrayOperator() {
        Integer[] strings = {100, 101, 102, 103};
        Observable.fromArray(strings)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {

                        MLog.e("array", integer + "");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void justOperator() {

        Observable<String> observable = Observable.just("one", "two", "three");
        observable.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                MLog.e("just", s);
            }
        });


    }

    private void createOperator() {

        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                MLog.e("just", integer + "");

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);
    }
}
