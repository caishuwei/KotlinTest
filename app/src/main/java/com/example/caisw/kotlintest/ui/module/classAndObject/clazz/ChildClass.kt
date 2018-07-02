package com.example.caisw.kotlintest.ui.module.classAndObject.clazz

import android.widget.Toast
import com.example.caisw.kotlintest.app.MyApplication

/**
 * Created by caisw on 2018/1/31.
 */
class ChildClass:ParentClass,ParentInterface{

    constructor() : super(){
    }

    override fun run() {
        //当父类与接口有方法冲突时，子类必须复写方法，并做自己的实现
        super<ParentClass>.run()
        super<ParentInterface>.run()
    }

}