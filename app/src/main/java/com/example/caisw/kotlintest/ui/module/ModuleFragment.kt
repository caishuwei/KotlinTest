package com.example.caisw.kotlintest.ui.module

import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.example.caisw.kotlintest.R
import com.example.caisw.kotlintest.adapter.FunctionAdapter
import com.example.caisw.kotlintest.entities.FragmentData
import com.example.caisw.kotlintest.ui.base.BaseFragment
import com.example.caisw.kotlintest.ui.module.basics.basicTypes.ValueFragment
import com.example.caisw.kotlintest.ui.module.basics.controlFlow.ControlFlowFragment
import com.example.caisw.kotlintest.ui.module.basics.packages.PackageFragment
import com.example.caisw.kotlintest.ui.module.basics.returnAndJump.ReturnAndJumpFragment
import com.example.caisw.kotlintest.ui.module.classAndObject.clazz.ClassAndExtendsFragment
import kotlinx.android.synthetic.main.fragment_function.*

/**
 * Created by caisw on 2018/1/10.
 */
open class ModuleFragment : BaseFragment() {

    companion object {
        //基础
        val BASICS_PACKAGE_DEFINE_FRAGMENT: FragmentData = FragmentData("包定义", PackageFragment::class.java.name, ModuleFragment.createData("包定义"))
        val BASICS_VALUE_FRAGMENT: FragmentData = FragmentData("基本类型", ValueFragment::class.java.name, ModuleFragment.createData("基本类型"))
        val BASICS_CONTROL_FLOW_FRAGMENT: FragmentData = FragmentData("流程控制", ControlFlowFragment::class.java.name, ModuleFragment.createData("流程控制"))
        val BASICS_RETURN_AND_JUMP_FRAGMENT: FragmentData = FragmentData("返回与跳转", ReturnAndJumpFragment::class.java.name, ModuleFragment.createData("返回与跳转"))

        //类和对象
        val CLASS_CLASS_AND_EXTENDS_FRAGMENT: FragmentData = FragmentData("类和继承", ClassAndExtendsFragment::class.java.name, ModuleFragment.createData("类和继承"))


        fun createData( title: String): Bundle {
            var data = Bundle()
            data.putString("title", title)
            return data
        }
    }

    private lateinit var adapter: FunctionAdapter

    override fun getContentViewResId(): Int {
        return R.layout.fragment_function
    }

    override fun initView() {
        super.initView()
        recycler_view.layoutManager = LinearLayoutManager(activity)

    }

    override fun initAdapter() {
        super.initAdapter()
        adapter = FunctionAdapter()
        recycler_view.adapter = adapter
    }

    override fun initData() {
        super.initData()
        val title = arguments.getString("title")
        if(title!=null&&activity is AppCompatActivity){
            activity.title = title
        }
    }

    fun updateFunctionContent(listData: MutableList<MultiItemEntity>) {
        adapter.setNewData(listData)
    }
}