package com.dangxy.androidpractice.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Flowable;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/23
 */
@Dao
public interface UserDao {
    @Query("SELECT  * FROM user")
    Flowable <List<User>> findAll();

    @Insert
    void addUser(User user);

    @Delete
    void deleteUser(User user);

    @Update
    void updateUser(User user);
}
