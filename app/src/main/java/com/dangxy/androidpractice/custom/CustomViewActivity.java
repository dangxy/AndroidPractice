package com.dangxy.androidpractice.custom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dangxy.androidpractice.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author dangxy99
 * @description 描述
 * @date 2017/12/27
 */
public class CustomViewActivity extends AppCompatActivity {

    @BindView(R.id.paint)
    Button paint;
    @BindView(R.id.canvas)
    Button canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.paint, R.id.canvas})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.paint:

                break;
            case R.id.canvas:
                break;
            default:
                break;
        }
    }
}
