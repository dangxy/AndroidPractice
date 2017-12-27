package com.dangxy.androidpractice.view.viewgroup;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.dangxy.androidpractice.utils.MLog;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/27
 */

public class SonView extends AppCompatTextView {

    public SonView(Context context) {
        super(context);
    }

    public SonView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                MLog.e("DANG","son onTouchEvent action_down");
                break;
            case MotionEvent.ACTION_UP:
                MLog.e("DANG","son onTouchEvent action_up");
                break;
            case MotionEvent.ACTION_CANCEL:
                MLog.e("DANG","son onTouchEvent action_cancel");
                break;
            default:
                break;
        }


        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                MLog.e("DANG","son dispatchTouchEvent action_down");
                break;
            case MotionEvent.ACTION_UP:
                MLog.e("DANG","son dispatchTouchEvent action_up");
                break;
            case MotionEvent.ACTION_CANCEL:
                MLog.e("DANG","son dispatchTouchEvent  action_cancel");
                break;
            default:
                break;
        }

        return super.dispatchTouchEvent(ev);
    }
}
