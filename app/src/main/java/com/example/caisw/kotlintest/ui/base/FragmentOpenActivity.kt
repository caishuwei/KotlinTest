package com.example.caisw.kotlintest.ui.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import com.example.caisw.kotlintest.R
import com.example.caisw.kotlintest.util.ActivityHelper

/**
 *  碎片界面
 * Created by caisw on 2018/1/8.
 */
class FragmentOpenActivity : BaseActivity() {
    //companion object 内部书写静态变量与方法
    companion object {

        /**
         * 打开界面
         * @param context 当前上下文
         * @param clazz 碎片类型
         * @param data 碎片初始化数据
         */
        fun openActivity(context: Context, className: String, data: Bundle?) {
            //class对象获取java:类名.class kotlin:类名.javaClass
            val intent = Intent(context, FragmentOpenActivity::class.java)
            intent.putExtra("className", className)
            if (data != null) {
                intent.putExtra("data", data)
            }
            context.startActivity(intent)
        }

    }

    override fun getContentViewResId(): Int {
        return R.layout.activity_fragment_open
    }

    override fun initData() {
        super.initData()
        val className = this.intent.getStringExtra("className")
        val data = this.intent.getBundleExtra("data")
        if (!TextUtils.isEmpty(className)) {
            ActivityHelper.setFragment<Fragment>(this.supportFragmentManager, R.id.fl_fragment_container, Class.forName(className) as Class<Fragment>, className, data)
        }
    }
}