package com.dangxy.androidpractice.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.dangxy.androidpractice.AppApplication;
import com.dangxy.androidpractice.utils.MLog;
import com.dangxy.androidpractice.utils.ViewDisplayHelper;

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

        MLog.e("DANG", height + "--" + widgth);
        MLog.e("DANG", ViewDisplayHelper.px2dp(AppApplication.getContext(),height) + "++" + ViewDisplayHelper.px2dp(AppApplication.getContext(),widgth));

        setMeasuredDimension(widgth,height);


    }
}
