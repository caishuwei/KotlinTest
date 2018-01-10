package com.example.caisw.kotlintest.util

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import java.lang.Exception


/**
 * Activity帮助类
 * Created by caisw on 2018/1/8.
 */
class ActivityHelper {

    companion object {

        /**
         * 设置碎片到容器中
         * @param fm 碎片管理器
         * @param containerId
         */
        fun <T : Fragment> setFragment(fm: FragmentManager, containerId: Int, fragmentClass: Class<T>, tag: String, data: Bundle?): T? {
            var fragment: T? = null
            try {
                //从碎片管理器寻找
                val cache = fm.findFragmentByTag(tag)
                if (cache != null && cache::class.java == fragmentClass) {
                    //使用 as操作符 进行强转
                    fragment = cache as T
                }
                //不存在实例，通过反射实例化
                if (fragment == null) {
                    fragment = fragmentClass.newInstance()
                }
            } catch (e: Exception) {
                //获取Fragment实例过程中出现问题
            }
            if (fragment != null) {
                val fragmentTransaction = fm.beginTransaction()
                if (fragment.isAdded) {
                    if (fragment.isDetached) {
                        fragmentTransaction.attach(fragment)
                    }
                } else {
                    if (data != null) {
                        fragment.arguments = data
                    }
                    fragmentTransaction.replace(containerId, fragment, tag)
                }
                fragmentTransaction.commitAllowingStateLoss()
            }
            return fragment
        }

    }


}