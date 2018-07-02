package com.example.caisw.kotlintest.app

import android.app.Application

/**
 * Created by caisw on 2018/1/4.
 */

public class MyApplication : Application() {

    companion object {
        lateinit var instance: MyApplication
    }

    init {
        MyApplication.instance = this
    }

}
