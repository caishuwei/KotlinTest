package com.example.caisw.kotlintest.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Activity基类
 * Created by caisw on 2018/1/8.
 */
abstract class BaseActivity : AppCompatActivity(), IUIInit {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentViewResId())
        initView()
        initAdapter()
        initListener()
        initData()
    }

    override fun initView() {
    }

    override fun initAdapter() {
    }

    override fun initListener() {
    }

    override fun initData() {
    }
}