package com.dangxy.androidpractice.back;

import android.app.Activity;
import android.os.Bundle;

import com.dangxy.androidpractice.R;

public class BackActivity extends Activity {

    private  SwipeBackDelegate swipeBackDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        swipeBackDelegate = new SwipeBackDelegate();
        swipeBackDelegate.attach(this,R.layout.activity_back);
        swipeBackDelegate.setDragEdge(SwipeBackLayout.DragEdge.LEFT);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
