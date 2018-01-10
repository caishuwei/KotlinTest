package com.example.caisw.kotlintest.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 碎片基类
 * Created by caisw on 2018/1/8.
 */
abstract class BaseFragment :Fragment(),IUIInit{

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(getContentViewResId(),container,false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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