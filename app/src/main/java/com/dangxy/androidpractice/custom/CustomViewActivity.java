package com.dangxy.androidpractice.custom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.dangxy.androidpractice.R;
import com.dangxy.androidpractice.utils.MLog;
import com.dangxy.androidpractice.utils.ViewDisplayHelper;

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
    @BindView(R.id.seekbar_width)
    SeekBar seekbarWidth;
    @BindView(R.id.seekbar_height)
    SeekBar seekbarHeight;
    @BindView(R.id.firs_image)
    FirstImageView firsImage;
    @BindView(R.id.ll)
    LinearLayout linearLayout;
    private CustomViewActivity mContext;
    private LinearLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        ButterKnife.bind(this);
        mContext =this;


        seekbarWidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                MLog.e("DANG", i + "");
                layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = ViewDisplayHelper.dp2px(mContext, (5*i));
                layoutParams.height = ViewDisplayHelper.dp2px(mContext, 150);
                linearLayout.setLayoutParams(layoutParams);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekbarHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.height = ViewDisplayHelper.dp2px(mContext, (5*i));
                layoutParams.width= ViewDisplayHelper.dp2px(mContext, 150);
                linearLayout.setLayoutParams(layoutParams);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @OnClick({R.id.paint, R.id.canvas})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.paint:
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) firsImage.getLayoutParams();

                layoutParams.width = ViewDisplayHelper.dp2px(this, 150);
                layoutParams.height = ViewDisplayHelper.dp2px(this, 200);
                firsImage.setLayoutParams(layoutParams);
                break;
            case R.id.canvas:

                break;
            default:
                break;
        }
    }
}
