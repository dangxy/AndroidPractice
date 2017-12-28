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

public class CircleView extends View {

    private Paint paint = new Paint();

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawArc(canvas);
    }

    /**
     * 画空心圆
     *
     * @param canvas
     */
    private void drawCircle(Canvas canvas) {
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        paint.setAntiAlias(true);
        canvas.drawCircle(200, 200, 200, paint);

    }

    /**
     * 画实心圆
     *
     * @param canvas
     */
    private void drawCircle1(Canvas canvas) {
        paint.setColor(Color.parseColor("#d70051"));
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        canvas.drawCircle(200, 200, 200, paint);
    }

    /**
     * 画矩形
     *
     * @param canvas
     */
    private void drawReat(Canvas canvas) {
        paint.setColor(Color.parseColor("#d70051"));
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        canvas.drawRect(200, 200, 600, 600, paint);
    }

    /**
     * 画点
     *
     * @param canvas
     */
    private void drawPoint(Canvas canvas) {
        paint.setColor(Color.parseColor("#d70051"));
        paint.setStrokeWidth(20);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(50, 50, paint);
    }

    /**
     * 画椭圆
     *
     * @param canvas
     */
    private void drawOval(Canvas canvas) {
        paint.setColor(Color.parseColor("#d70051"));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawOval(400, 50, 700, 200, paint);
    }

    /**
     * 画饼图
     *
     * @param canvas
     */
    private void drawArc(Canvas canvas) {
        paint.setColor(Color.parseColor("#d70051"));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(200, 100, 800, 500, -100, 100, true, paint);
        canvas.drawArc(200, 100, 800, 500, 20, 140, false, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(200, 100, 800, 500, 180, 60, false, paint);

    }

}
