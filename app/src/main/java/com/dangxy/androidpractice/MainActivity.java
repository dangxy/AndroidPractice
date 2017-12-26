package com.dangxy.androidpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;

import com.dangxy.androidpractice.fragment.GankActivity;
import com.dangxy.androidpractice.fragment.ReadhubFragment;
import com.dangxy.androidpractice.readhub.ReadHubActivity;
import com.dangxy.androidpractice.utils.MLog;
import com.f2prateek.rx.preferences2.Preference;
import com.f2prateek.rx.preferences2.RxSharedPreferences;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import rx.Subscriber;

/**
 * @author dangxy99
 * @description 描述
 * @date 2017/12/23
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.gank)
    Button gank;
    @BindView(R.id.Readhub)
    Button Readhub;
    private Intent intent;
    private CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        checkbox = (CheckBox) findViewById(R.id.checkbox);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //在Activity中添加fragment
        getSupportFragmentManager().beginTransaction().add(R.id.fl, ReadhubFragment.newInstance(), "readhub").commit();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.edit().putString("username", "dangxy11").commit();
        sharedPreferences.edit().putBoolean("isChecked", true).commit();
        RxSharedPreferences rxSharedPreferences = RxSharedPreferences.create(sharedPreferences);

        Preference<String> stringPreference = rxSharedPreferences.getString("username");
        Preference<Boolean> isChecked = rxSharedPreferences.getBoolean("isChecked", false);


        stringPreference.asObservable().subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {

                MLog.e("DANG", "s" + s);
            }
        });

        //RxCompoundButton.checkedChanges(checkbox).subscribe(isChecked.asConsumer());
        isChecked.asObservable().subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {

                if (aBoolean) {
                    MLog.e("DANG", "true");
                }
            }
        });
        ObservableOnSubscribe<String> onSubscribe = new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {

                e.onNext("61");
                e.onComplete();
            }
        };
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer string) throws Exception {

                MLog.e("DANG", (string + 5) + "");
            }


        };

        Function<String, Integer> func1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) throws Exception {
                return Integer.parseInt(s);
            }
        };
        Observable.create(onSubscribe)
                .map(func1)
                .subscribe(consumer);
        Observable.create(onSubscribe).map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) throws Exception {
                return Integer.parseInt(s);
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.gank, R.id.Readhub, R.id.checkbox})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gank:
                intent = new Intent(this, GankActivity.class);
                startActivity(intent);

                break;
            case R.id.Readhub:
                intent = new Intent(this, ReadHubActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
