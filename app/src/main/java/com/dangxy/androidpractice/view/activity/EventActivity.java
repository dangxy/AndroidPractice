package com.dangxy.androidpractice.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.dangxy.androidpractice.R;
import com.dangxy.androidpractice.utils.MLog;
import com.dangxy.androidpractice.view.viewgroup.SonView;

/**
 * @author dangxy99
 * @description 描述
 * @date 2017/12/27
 */
public class EventActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private SonView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        view = findViewById(R.id.event_view);
        view.setOnClickListener(this);
        view.setOnTouchListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.event_view:
                MLog.e("DANG", view + "on click");
                break;
            default:
                break;
        }


    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (view.getId()) {
            case R.id.event_view:
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        MLog.e("DANG", "view action_down");
                        break;
                    case MotionEvent.ACTION_UP:
                        MLog.e("DANG", "view action_up");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        MLog.e("DANG", "view action_move");
                        break;
                    default:
                        break;
                }
                default:
                    break;
        }

        return false;
    }


}
