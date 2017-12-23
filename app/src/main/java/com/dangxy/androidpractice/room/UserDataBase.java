package com.dangxy.androidpractice.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/23
 */
@Database(entities = {User.class},version = 1, exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {


    public  abstract UserDao  userDao();
}
