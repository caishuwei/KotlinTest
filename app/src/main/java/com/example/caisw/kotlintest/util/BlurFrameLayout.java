package com.example.caisw.kotlintest.util;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by caisw on 2018/1/18.
 */
public class BlurFrameLayout extends FrameLayout {
    private final BlurCalculate mBlurCalculate;

    public BlurFrameLayout(@NonNull Context context) {
        this(context,null);
    }

    public BlurFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BlurFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mBlurCalculate=new BlurCalculate(this);
    }

    /***
     * radius for linearlayout***/
    public void setRadius(int arg0)
    {
        if(mBlurCalculate!=null)
            mBlurCalculate.setRadius(arg0);
        invalidate();
    }
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mBlurCalculate.onAttachedToWindow();
    }
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mBlurCalculate.BluronDetachedFromWindow();
    }
    @Override
    protected void dispatchDraw(Canvas canvas) {
        if(mBlurCalculate.isCanvasChanged(canvas))
            mBlurCalculate.BlurCanvas();
        else
        {
            mBlurCalculate.DrawCanvas(canvas);
            super.dispatchDraw(canvas);

        }
    }
}
