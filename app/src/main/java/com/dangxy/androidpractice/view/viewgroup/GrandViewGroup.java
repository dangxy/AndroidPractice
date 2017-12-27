package com.dangxy.androidpractice.view.viewgroup;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.dangxy.androidpractice.utils.MLog;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/27
 */

public class GrandViewGroup extends LinearLayout {

    public GrandViewGroup(Context context) {
        super(context);
    }

    public GrandViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GrandViewGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                MLog.e("DANG","grand onInterceptTouchEvent action_down");
                break;
            case MotionEvent.ACTION_UP:
                MLog.e("DANG","grand onInterceptTouchEvent action_up");
                break;
            case MotionEvent.ACTION_CANCEL:
                MLog.e("DANG","grand onInterceptTouchEvent action_cancel");
                break;
            default:
                break;
        }


        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                MLog.e("DANG","grand onTouchEvent action_down");
                break;
            case MotionEvent.ACTION_UP:
                MLog.e("DANG","grand onTouchEvent action_up");
                break;
            case MotionEvent.ACTION_CANCEL:
                MLog.e("DANG","grand onTouchEvent action_cancel");
                break;
            default:
                break;
        }


        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                MLog.e("DANG","grand dispatchTouchEvent action_down");
                break;
            case MotionEvent.ACTION_UP:
                MLog.e("DANG","grand dispatchTouchEvent action_up");
                break;
            case MotionEvent.ACTION_CANCEL:
                MLog.e("DANG","grand dispatchTouchEvent  action_cancel");
                break;
            default:
                break;
        }

        return super.dispatchTouchEvent(ev);
    }
}
