package com.dangxy.androidpractice;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.dangxy.androidpractice.greendao.DaoMaster;
import com.dangxy.androidpractice.greendao.DaoSession;

import io.fabric.sdk.android.Fabric;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/23
 */

public class AppApplication extends Application {

    private static Context mContext;
    private static DaoSession daoSession;

    public static Context getContext() {

        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        mContext = getApplicationContext();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("dognew.realm")
                .schemaVersion(2)
                .build();
        Realm.setDefaultConfiguration(config);
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(AppApplication.getContext(), "student-db.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
         daoSession = daoMaster.newSession();


    }
    public static DaoSession getSession(){

        return daoSession;
    }
}
