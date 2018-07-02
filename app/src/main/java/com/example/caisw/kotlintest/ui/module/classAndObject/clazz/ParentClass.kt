package com.example.caisw.kotlintest.ui.module.classAndObject.clazz

import android.widget.Toast
import com.example.caisw.kotlintest.app.MyApplication

/**
 * Created by caisw on 2018/1/31.
 */
open class ParentClass {

    open fun run(){
        Toast.makeText(MyApplication.instance,"执行父类run方法",Toast.LENGTH_SHORT).show()
    }

}