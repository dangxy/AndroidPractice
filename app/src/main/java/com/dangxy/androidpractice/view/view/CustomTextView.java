package com.dangxy.androidpractice.view.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.dangxy.androidpractice.utils.MLog;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/27
 */

public class CustomTextView extends AppCompatTextView {


    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                  MLog.e("DANG","dispatchTouchEvent action_down");
                break;
            case MotionEvent.ACTION_UP:
                MLog.e("DANG", "dispatchTouchEvent action_up");
                break;
            case MotionEvent.ACTION_CANCEL:
                MLog.e("DANG", "dispatchTouchEvent action_cancel");
                break;
            default:
                break;
        }
          MLog.e("DANG","dispatchTouchEvent~~~"+super.dispatchTouchEvent(event));
        return super.dispatchTouchEvent(event);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                  MLog.e("DANG","onTouchEvent action_down");
                break;
            case MotionEvent.ACTION_UP:
                MLog.e("DANG", "onTouchEvent action_up");
                break;
            case MotionEvent.ACTION_CANCEL:
                MLog.e("DANG", "onTouchEvent action_cancel");
                break;
            default:
                break;
        }
        MLog.e("DANG","onTouchEvent~~~"+super.onTouchEvent(event));
        return super.onTouchEvent(event);
    }
}
