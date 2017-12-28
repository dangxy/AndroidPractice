package com.dangxy.androidpractice.custom.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.dangxy.androidpractice.R;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/28
 */

public class PaintView extends View {
    private Paint paint = new Paint();

    public PaintView(Context context) {
        super(context);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //paint 画圆
        paint.setColor(Color.BLACK);
        canvas.drawCircle(200, 200, 100, paint);
        // paint 画Bitmap
        Resources resource =getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(resource,R.drawable.user_avatar);
        canvas.drawBitmap(bitmap,100,100,paint);

    }
}
