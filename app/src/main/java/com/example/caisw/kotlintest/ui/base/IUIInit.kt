package com.example.caisw.kotlintest.ui.base

/**
 * UI初始化接口
 * Created by caisw on 2018/1/8.
 */
interface IUIInit {
    /**
     * 获取布局ID
     */
    fun getContentViewResId(): Int

    /**
     * 初始化视图
     */
    fun initView()

    /**
     * 初始化适配器
     */
    fun initAdapter()

    /**
     * 初始化监听
     */
    fun initListener()

    /**
     * 初始化界面数据
     */
    fun initData()
}