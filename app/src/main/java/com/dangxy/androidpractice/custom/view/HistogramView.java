package com.dangxy.androidpractice.custom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/28
 */

public class HistogramView extends View {
    private Paint paint = new Paint();

    public HistogramView(Context context) {
        super(context);
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.parseColor("#d70051"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        canvas.drawLine(100, 100, 100, 700, paint);
        canvas.drawLine(100, 700, 1000, 700, paint);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(140, 680, 210, 700, paint);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(220, 100, 290, 700, paint);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(300, 250, 370, 700, paint);
        canvas.drawRect(380, 500, 450, 700, paint);
        canvas.drawRect(480, 200, 550, 700, paint);


    }
}
