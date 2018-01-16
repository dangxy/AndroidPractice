package com.dangxy.androidpractice.ormlite;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dangxy.androidpractice.AppApplication;
import com.dangxy.androidpractice.R;
import com.dangxy.androidpractice.utils.MLog;

import java.sql.SQLException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author dangxy99
 * @description 描述
 * @date 2018/1/16
 */
public class OrmliteActivity extends Activity {

    @BindView(R.id.add)
    Button add;
    @BindView(R.id.update)
    Button update;
    @BindView(R.id.delete)
    Button delete;
    @BindView(R.id.query)
    Button query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ormlite);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.add, R.id.update, R.id.delete, R.id.query})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add:
                for (int i = 1; i < 300; i++) {
                    UserInfo userInfo = new UserInfo();
                    userInfo.setUserName("dangxy" + i);
                    userInfo.setPassword("password" + i * i);
                    try {
                        AndroidOrmlistOpenHelper.getHelper(AppApplication.getContext()).addUser(userInfo);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                break;
            case R.id.update:
                try {
                    AndroidOrmlistOpenHelper.getHelper(this).updateByPassword("password1");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.delete:
                try {
                    AndroidOrmlistOpenHelper.getHelper(this).deleteUserByName("dangxy2");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.query:
                try {

                    List<UserInfo> list = AndroidOrmlistOpenHelper.getHelper(this).queryUserAll();


                    for (UserInfo userInfo :
                            list
                            ) {

                        MLog.e("DANG", userInfo.getUserName() + "----" + userInfo.getPassword());

                    }


                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }
}
