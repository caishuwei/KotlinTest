package com.example.caisw.kotlintest.ui.module.classAndObject.clazz

import android.widget.Toast
import com.example.caisw.kotlintest.app.MyApplication

/**
 * Created by caisw on 2018/1/31.
 */
interface ParentInterface{

    fun run(){//接口的所有方法都是open
        //接口方法可以有实现。。。。
        Toast.makeText(MyApplication.instance,"执行接口run方法", Toast.LENGTH_SHORT).show()
    }

}