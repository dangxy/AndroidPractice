package com.dangxy.androidpractice.custom.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.dangxy.androidpractice.utils.MLog;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/28
 */

public class FirstTextView extends AppCompatTextView {

    public FirstTextView(Context context) {
        super(context);
    }

    public FirstTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FirstTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int height = getMeasuredHeight();
        int widgth = getMeasuredWidth();

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);


        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        MLog.e("DANG", widthMode + "--" + widthSize);
        MLog.e("DANG", heightMode + "++" + heightSize);


        setMeasuredDimension(widgth, height);


    }
}
