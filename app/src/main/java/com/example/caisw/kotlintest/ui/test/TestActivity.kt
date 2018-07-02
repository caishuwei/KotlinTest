package com.example.caisw.kotlintest.ui.test

import com.example.caisw.kotlintest.ui.base.FragmentOpenActivity

/**
 * Created by caisw on 2018/2/1.
 */
class TestActivity : FragmentOpenActivity() {

    override fun initData() {
        intent.putExtra("className", TestFragment::class.java.name)
        super.initData()
    }

}