package com.example.caisw.kotlintest.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Matrix
import android.os.SystemClock
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.caisw.kotlintest.R

/**
 * Created by caisw on 2018/2/1.
 */
class RingView : View {
    companion object {
        private val startTime: Long by lazy {
            SystemClock.uptimeMillis()
        }
    }
    private val frameUpdateTime = 50L
    private val ringW = 75
    private val ringH = 75

    private lateinit var ringArr: Bitmap
    private lateinit var ring: Bitmap
    private val refreshTask = { ->
        invalidate()
    }
    private val ringMatrix = Matrix()
    private val intArr = IntArray(75 * 75)

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView()
    }

    private fun initView() {
        ringArr = BitmapFactory.decodeResource(resources, R.drawable.ring)
        ring = Bitmap.createBitmap(ringW, ringH, Bitmap.Config.ARGB_8888)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val scaleX = width * 1F / ringW
        val scaleY = height * 1F / ringH
        val scale = Math.min(scaleX, scaleY)
        ringMatrix.reset()
        ringMatrix.postScale(scale, scale)
        ringMatrix.postTranslate((width - scale * ringW) / 2, (height - scale * ringH) / 2)
        canvas?.drawBitmap(getCurrDrawableBitmap(), ringMatrix, null)
        postDelayed(refreshTask, frameUpdateTime)
    }

    private fun getCurrDrawableBitmap(): Bitmap {
        //6x8
        val pictureIndex = ((SystemClock.uptimeMillis() - RingView.startTime) / frameUpdateTime).toInt() % 48
        val x = pictureIndex % 6
        val y = pictureIndex / 6
        ringArr.getPixels(intArr, 0, ringW, x * ringW, y * ringH, ringW, ringH)
        ring.setPixels(intArr, 0, ringW, 0, 0, ringW, ringH)
        return ring
    }
}