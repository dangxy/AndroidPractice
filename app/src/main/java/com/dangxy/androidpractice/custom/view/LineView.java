package com.dangxy.androidpractice.custom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.dangxy.androidpractice.utils.MLog;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/29
 */

public class LineView extends View {
    private Paint paint = new Paint();
    private int lastX;

    public LineView(Context context) {
        super(context);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#d70051"));
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);
        canvas.drawLine(0, 100, 3700, 100, paint);
        paint.setTextSize(16);
        canvas.drawText(0 + "", 0, 100 + 20, paint);
        for (int i = 1; i <= 100; i++) {
            if (i % 5 == 0 && String.valueOf(i).contains("5")&&i%10!=0) {
                canvas.drawLine(0 + ((i - 1) * 20), 60, 0 + ((i - 1) * 20), 100, paint);
            } else if (i % 10 == 0) {
                canvas.drawLine(0 + ((i - 1) * 20), 40, 0 + ((i - 1) * 20), 100, paint);
                 paint.setTextSize(16);
                canvas.drawText(i + "", 0 + ((i - 1) * 20) - 10, 100 + 20, paint);
            } else {
                canvas.drawLine(0 + ((i - 1) * 20), 70, 0 + ((i - 1) * 20), 100, paint);
            }

        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                break;
            case MotionEvent.ACTION_MOVE:

                int offX = x - lastX;

                layout(getLeft() + offX, getTop(), getRight() + offX, getBottom());
                break;
            case MotionEvent.ACTION_UP:
                break;

            default:
                break;

        }
        return true;
    }
}
