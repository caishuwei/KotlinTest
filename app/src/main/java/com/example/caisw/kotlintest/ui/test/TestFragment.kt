package com.example.caisw.kotlintest.ui.test

import android.os.Bundle
import android.util.Log
import com.example.caisw.kotlintest.R
import com.example.caisw.kotlintest.ui.base.BaseFragment
import com.example.caisw.kotlintest.util.ActivityHelper
import kotlinx.android.synthetic.main.fragment_test.*

/**
 * Created by caisw on 2018/1/8.
 */
class TestFragment : BaseFragment() {

    companion object {

        fun createBundle(tag: String): Bundle {
            val data = Bundle()
            data.putString("tag",tag)
            return data
        }

    }

    override fun getContentViewResId(): Int {
        return R.layout.fragment_test
    }

    override fun initView() {
        super.initView()
    }

    override fun initData() {
        super.initData()
        tv_test_text.text = "test for ${this.arguments.getString("tag")}"
    }
}