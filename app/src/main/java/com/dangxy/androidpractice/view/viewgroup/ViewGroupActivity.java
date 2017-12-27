package com.dangxy.androidpractice.view.viewgroup;

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
public class ViewGroupActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private GrandViewGroup grandView;
    private ParentViewGroup parentView;
    private SonView sonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_gou);
        grandView = findViewById(R.id.grand);
        parentView = findViewById(R.id.parent);
        sonView = findViewById(R.id.son);

        grandView.setOnClickListener(this);
        parentView.setOnClickListener(this);
        sonView.setOnClickListener(this);

        grandView.setOnTouchListener(this);
        parentView.setOnTouchListener(this);
        sonView.setOnTouchListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.grand:
                  MLog.e("DANG","gand  onclick");
                break;
            case R.id.parent:
                MLog.e("DANG","parent  onclick");
                break;
            case R.id.son:
                MLog.e("DANG","son  onclick");
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch (view.getId()) {
            case R.id.grand:
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        MLog.e("DANG", "grand  onTouch  action_down");
                        break;
                    case MotionEvent.ACTION_UP:
                        MLog.e("DANG", "grand  onTouch action_up");
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        MLog.e("DANG", "grand  onTouch  action_cancel");
                        break;
                    default:
                        break;
                }
                break;
            case R.id.parent:
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        MLog.e("DANG", "parent  onTouch  action_down");
                        break;
                    case MotionEvent.ACTION_UP:
                        MLog.e("DANG", "parent  onTouch action_up");
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        MLog.e("DANG", "parent  onTouch  action_cancel");
                        break;
                    default:
                        break;
                }

                break;
            case R.id.son:
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        MLog.e("DANG", "son  onTouch  action_down");
                        break;
                    case MotionEvent.ACTION_UP:
                        MLog.e("DANG", "son  onTouch action_up");
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        MLog.e("DANG", "son  onTouch  action_cancel");
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
