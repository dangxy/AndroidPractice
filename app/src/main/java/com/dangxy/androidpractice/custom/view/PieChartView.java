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

public class PieChartView extends View {
    private Paint paint = new Paint();

    public PieChartView(Context context) {
        super(context);
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.parseColor("#d70051"));
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        canvas.drawArc(100,100,800,800,0,10,true,paint);
        paint.setColor(Color.parseColor("#cbaf76"));
        canvas.drawArc(100,100,800,800,10,20,true,paint);
        paint.setColor(Color.parseColor("#3c62d5"));
        canvas.drawArc(100,100,800,800,30,60,true,paint);
        paint.setColor(Color.parseColor("#00a79d"));
        canvas.drawArc(100,100,800,800,90,90,true,paint);
        paint.setColor(Color.parseColor("#cbaf76"));
        canvas.drawArc(100,100,800,800,180,150,true,paint);
        paint.setColor(Color.parseColor("#ff3a83"));
        canvas.drawArc(100,100,800,800,330,30,true,paint);


    }
}
