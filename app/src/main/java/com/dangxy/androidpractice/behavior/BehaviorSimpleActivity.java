package com.dangxy.androidpractice.behavior;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.dangxy.androidpractice.R;
/**
 * @description  描述
 * @author  dangxy99
 * @date   2018/1/4
 */
public class BehaviorSimpleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior_simple);
        findViewById(R.id.btn).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_MOVE)
                {
                    view.setX(motionEvent.getRawX()-view.getWidth()/2);
                    view.setY(motionEvent.getRawY()-view.getHeight()/2);
                }
                return true;
            }
        });
    }
}
