package com.dangxy.androidpractice.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @author dangxueyi
 * @description
 * @date 2018/1/16
 */

public class AndroidOrmlistOpenHelper extends OrmLiteSqliteOpenHelper {

    private static final String TABLE_NAME = "table_user.db";

    private static AndroidOrmlistOpenHelper instance;

    private Dao<UserInfo, Integer> userDao;


    public AndroidOrmlistOpenHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {


        try {
            TableUtils.createTable(connectionSource, UserInfo.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, UserInfo.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public  static synchronized AndroidOrmlistOpenHelper getHelper(Context context) {
        if (instance == null) {
            synchronized (AndroidOrmlistOpenHelper.class) {
                if (instance == null) {
                    instance = new AndroidOrmlistOpenHelper(context);
                }
            }
        }

        return instance;
    }

    public Dao<UserInfo, Integer> getUser() throws SQLException {

        if (userDao == null) {
            userDao = getDao(UserInfo.class);
        }

        return userDao;

    }

    public void deleteUserByName(String name) throws SQLException {
        DeleteBuilder deleteBuilder = getUser().deleteBuilder();
        deleteBuilder.where().eq("username", name);
        deleteBuilder.delete();
    }

    public void addUser(UserInfo userInfo) throws SQLException {
        getUser().create(userInfo);
    }

    public List<UserInfo> queryUserAll() throws SQLException {
       QueryBuilder<UserInfo,Integer> queryBuilder = getUser().queryBuilder();

        return getUser().queryForAll();
    }
    public void updateByPassword(String password) throws SQLException {
      UpdateBuilder updateBuilder =  getUser().updateBuilder();

      updateBuilder.where().eq("password",password);
      updateBuilder.updateColumnValue("username","xydang");
      updateBuilder.update();
    }


    @Override
    public void close() {
        super.close();
        userDao = null;
    }


}
