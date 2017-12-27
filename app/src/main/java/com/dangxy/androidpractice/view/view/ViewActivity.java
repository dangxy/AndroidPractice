package com.dangxy.androidpractice.view.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.dangxy.androidpractice.R;
import com.dangxy.androidpractice.utils.MLog;

/**
 * @author dangxy99
 * @description 描述
 * @date 2017/12/27
 */
public class ViewActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        CustomTextView textView = findViewById(R.id.custom_text_view);

        textView.setOnClickListener(this);
        textView.setOnTouchListener(this);
    }

    @Override
    public void onClick(View view) {
        MLog.e("DANG", "view onclick");


    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch (view.getId()) {
            case R.id.custom_text_view:
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        MLog.e("DANG", "view action_down");
                        break;
                    case MotionEvent.ACTION_UP:
                        MLog.e("DANG", "view action_up");
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        MLog.e("DANG", "view action_cancel");
                        break;
                    default:
                        break;
                }

                break;
            default:
                break;
        }
        return false;
    }
}
