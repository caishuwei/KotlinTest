package com.example.caisw.kotlintest.ui.main

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.caisw.kotlintest.R
import com.example.caisw.kotlintest.adapter.MainAdapter

/**
 * 主界面<br/>
 *
 * 使用:代表继承，kotlin构造方式直接在继承后面写，目前空括号表示默认的构造函数？
 * 那么我怎么实现多种构造方式呢？
 *
 * Created by caisw on 2018/1/4.
 */
public class MainActivity : Activity() {

    //var表示变量，val表示常量，与python等动态语言一致，不知能否动态添加新变量
    private var recycler: RecyclerView? = null
    //变量都 需要初始化，你要么空（空也是一个实例，类型与我标注不一致），要么具体实例
    private var mainAdapter: MainAdapter? = null

    /**
     * 方法复写，override由注解变为与abstract final public类似的限定符<br/>
     * 参数写法为：参数名:参数类型，参数类型后面跟着?表示可以传空,不加问号传空会报错
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initAdapter()
        initListener()
        initData()
    }

    private fun initView() {
        recycler = this.findViewById(R.id.recycler)
        //对象实例化，不需要new关键字
        // 属性赋值时，如果已经声明set方法，对象.变量名=变量值即可
        //同理，如果已经声明get方法，对象.变量名直接拿到引用
        //有点溜，只要声明set与get就相当于public变量一样去访问就好了
        //由于recycler可能为null对象，所以需要?进行判断，为空不进行属性赋值
        recycler?.layoutManager = LinearLayoutManager(this)
    }

    private fun initAdapter() {
        //这么聪明的语言都不能连续赋值吗？
//        recycler?.mainAdapter = mainAdapter= MainAdapter()

        mainAdapter = MainAdapter()
        recycler?.adapter = mainAdapter
    }

    private fun initListener() {
        //使用lambda实现接口{p1,p2,p3...->运行代码}
        mainAdapter?.setOnItemClickListener(
                { adapter, view, position ->
                    //匿名内部类，通过this@外部类类名取得外部类引用
                    Toast.makeText(this@MainActivity, mainAdapter?.getItem(position), Toast.LENGTH_SHORT).show()
                }
        )
    }

    private fun initData() {
        //使用lambda创建动态集合,1~10
        val data: MutableList<String> = MutableList(10, { i -> "${i+1}" })
        data.add("11")
        mainAdapter?.setNewData(data)
    }

    private fun int2String(i: Int): String {
        return "$i"
    }
}