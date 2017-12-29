package com.dangxy.androidpractice.custom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Practice11PieChartView extends View {
    private List<Data> datas;
    private Paint paint;
    private RectF rectF;
    private float total;
    private float max;
    private boolean isMove = false;

    float startAngle = 0f;
    float sweepAngle;
    float lineAngle;

    float lineStartX = 0f;
    float lineStartY = 0f;
    float lineEndX;
    float lineEndY;

    public Practice11PieChartView(Context context) {
        super(context);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        datas = new ArrayList<>();
        Data data = new Data("Gingerbread", 10.0f, Color.WHITE);
        datas.add(data);
        data = new Data("Ice Cream Sandwich", 18.0f, Color.MAGENTA);
        datas.add(data);
        data = new Data("Jelly Bean", 22.0f, Color.GRAY);
        datas.add(data);
        data = new Data("KitKat", 27.0f, Color.GREEN);
        datas.add(data);
        data = new Data("Lollipop", 40.0f, Color.BLUE);
        datas.add(data);
        data = new Data("Marshmallow", 60.0f, Color.RED);
        datas.add(data);
        data = new Data("Nougat", 33.5f, Color.YELLOW);
        datas.add(data);
        total = 0.0f;
        max = Float.MIN_VALUE;
        for (Data d : datas) {
            total += d.getValue();
            max = Math.max(max, d.getValue());
        }
        paint = new Paint();
        paint.setStrokeWidth(2);
        paint.setTextSize(30);
        rectF = new RectF(-300, -300, 300, 300);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        canvas.translate(canvas.getWidth() / 2, canvas.getHeight() / 2);
        for (Data data : datas) {
            if (isMove) {
                canvas.translate(-lineStartX * 0.1f, -lineStartY * 0.1f);
                isMove = false;
            }
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(data.getColor());
            sweepAngle = data.getValue() / total * 360f;
            lineAngle = startAngle + sweepAngle / 2;
            lineStartX = 300 * (float) Math.cos(lineAngle / 180 * Math.PI);
            lineStartY = 300 * (float) Math.sin(lineAngle / 180 * Math.PI);
            lineEndX = 350 * (float) Math.cos(lineAngle / 180 * Math.PI);
            lineEndY = 350 * (float) Math.sin(lineAngle / 180 * Math.PI);
            if (data.getValue() == max) {
                canvas.translate(lineStartX * 0.1f, lineStartY * 0.1f);
                canvas.drawArc(rectF, startAngle, sweepAngle, true, paint);
                isMove = true;
            } else {
                canvas.drawArc(rectF, startAngle, sweepAngle - 1.0f, true, paint);
            }
            paint.setColor(Color.WHITE);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawLine(lineStartX, lineStartY, lineEndX, lineEndY, paint);
            if (lineAngle > 90 && lineAngle <= 270) {
                canvas.drawLine(lineEndX, lineEndY, lineEndX - 50, lineEndY, paint);
                canvas.drawText(data.getName(), lineEndX - 50 - 10 - paint.measureText(data.getName()), lineEndY, paint);
            } else {
                canvas.drawLine(lineEndX, lineEndY, lineEndX + 50, lineEndY, paint);
                canvas.drawText(data.getName(), lineEndX + 50 + 10, lineEndY, paint);
            }
            startAngle += sweepAngle;
        }
    }
}
