package com.example.caisw.kotlintest.ui.module

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.example.caisw.kotlintest.R
import com.example.caisw.kotlintest.adapter.FunctionAdapter
import com.example.caisw.kotlintest.entities.FragmentData
import com.example.caisw.kotlintest.ui.base.BaseFragment
import com.example.caisw.kotlintest.ui.module.basics.packageDefine.PackageFragment
import kotlinx.android.synthetic.main.fragment_function.*

/**
 * Created by caisw on 2018/1/10.
 */
open class ModuleFragment : BaseFragment() {

    companion object {
        val PACKAGE_DEFINE_FRAGMENT: FragmentData = FragmentData("包定义", PackageFragment::class.java.name, ModuleFragment.createData("包定义"))

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