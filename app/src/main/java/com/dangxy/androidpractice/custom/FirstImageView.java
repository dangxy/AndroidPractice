package com.dangxy.androidpractice.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.dangxy.androidpractice.utils.MLog;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/28
 */

public class FirstImageView extends AppCompatImageView {

    public FirstImageView(Context context) {
        super(context);
    }

    public FirstImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FirstImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

//        if (width > height) {
//            height = width;
//        } else {
//            width = height;
//        }
        MLog.e("DANG", height + "--" + width);
        setMeasuredDimension(width, height);
    }

}
