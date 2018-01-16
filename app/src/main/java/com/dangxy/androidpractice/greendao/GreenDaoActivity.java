package com.dangxy.androidpractice.greendao;

import android.app.Activity;
import android.os.Bundle;

import com.dangxy.androidpractice.AppApplication;
import com.dangxy.androidpractice.R;
import com.dangxy.androidpractice.utils.MLog;

import org.greenrobot.greendao.query.Query;

import rx.functions.Action1;

/**
 * @description  描述
 * @author  dangxy99
 * @date   2018/1/16
 */
public class GreenDaoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao);

        Student student = new Student();
        student.setAge("11");
        student.setUser("dangxy");
        AppApplication.getSession().getStudentDao().insert(student);


       Query<Student> query =  AppApplication.getSession().getStudentDao().queryBuilder().build();



       query.__InternalRx().oneByOne().asObservable().subscribe(new Action1<Student>() {
           @Override
           public void call(Student student1) {
               MLog.e("DANG",student1.getAge());
           }
       });

       AppApplication.getSession().getStudentDao().deleteByKey(1L);

       student.setUser("xydang");
       AppApplication.getSession().getStudentDao().update(student);



    }
}
