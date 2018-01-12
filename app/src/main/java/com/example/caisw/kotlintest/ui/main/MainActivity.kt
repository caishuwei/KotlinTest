package com.example.caisw.kotlintest.ui.main

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.example.caisw.kotlintest.R
import com.example.caisw.kotlintest.adapter.MainAdapter
import com.example.caisw.kotlintest.adapter.MultiItemEntityValue
import com.example.caisw.kotlintest.entities.FragmentData
import com.example.caisw.kotlintest.entities.Level0Item
import com.example.caisw.kotlintest.entities.Level1Item
import com.example.caisw.kotlintest.ui.base.BaseActivity
import com.example.caisw.kotlintest.ui.base.FragmentOpenActivity
import com.example.caisw.kotlintest.ui.module.ModuleFragment

/**
 * 主界面<br/>
 *
 * 使用:代表继承，kotlin构造方式直接在继承后面写，目前空括号表示默认的构造函数？
 * 那么我怎么实现多种构造方式呢？
 *
 * Created by caisw on 2018/1/4.
 */
public class MainActivity : BaseActivity() {

    //var表示变量，val表示常量，与python等动态语言一致，不知能否动态添加新变量
    private var recycler: RecyclerView? = null
    //变量都 需要初始化，你要么空（空也是一个实例，类型与我标注不一致），要么具体实例
    private var mainAdapter: MainAdapter<MultiItemEntity>? = null

    override fun getContentViewResId(): Int {
        return R.layout.activity_main
    }

    /**
     * 方法复写，override由注解变为与abstract final public类似的限定符<br/>
     * 参数写法为：参数名:参数类型，参数类型后面跟着?表示可以传空,不加问号传空会报错
     */
    override fun initView() {
        recycler = this.findViewById(R.id.recycler)
        //对象实例化，不需要new关键字
        // 属性赋值时，如果已经声明set方法，对象.变量名=变量值即可
        //同理，如果已经声明get方法，对象.变量名直接拿到引用
        //有点溜，只要声明set与get就相当于public变量一样去访问就好了
        //由于recycler可能为null对象，所以需要?进行判断，为空不进行属性赋值
        recycler?.layoutManager = LinearLayoutManager(this)
    }

    override fun initAdapter() {
        //这么聪明的语言都不能连续赋值吗？
//        recycler?.mainAdapter = mainAdapter= MainAdapter()

        mainAdapter = MainAdapter()
        recycler?.adapter = mainAdapter
    }

    override fun initListener() {
        //使用lambda实现接口{p1,p2,p3...->运行代码}
        mainAdapter?.setOnItemClickListener { adapter, view, position ->
            //匿名内部类，通过this@外部类类名取得外部类引用
//                    val value = mainAdapter?.getItem(position);
//                    if (value != null) {
//                        Toast.makeText(this@MainActivity, value, Toast.LENGTH_SHORT).show()
//                        FragmentOpenActivity.openActivity(this@MainActivity, TestFragment::class.java, TestFragment.createBundle(value))
//                    }
            when (mainAdapter?.getItemViewType(position)) {
                MultiItemEntityValue.TYPE_LEVEL_0 -> when ((mainAdapter?.getItem(position) as Level0Item).isExpanded) {
                    true -> mainAdapter?.collapse(position)
                    false -> mainAdapter?.expand(position)
                }
                MultiItemEntityValue.TYPE_LEVEL_1 -> when ((mainAdapter?.getItem(position) as Level1Item).isExpanded) {
                    true -> mainAdapter?.collapse(position)
                    false -> mainAdapter?.expand(position)
                }
                MultiItemEntityValue.TYPE_FRAGMENT_DATA -> openFragment(mainAdapter?.getItem(position) as FragmentData)
            }
        }

        mainAdapter?.setOnItemChildClickListener { adapter, view, position ->

        }
    }

    private fun openFragment(fragmentData: FragmentData) {
        FragmentOpenActivity.openActivity(this, fragmentData.className, fragmentData.data)
    }

    override fun initData() {
        //使用lambda创建动态集合,1~10
        val data: MutableList<MultiItemEntity> = mutableListOf()

        val l0_1 = Level0Item("准备开始")
        val l0_1_1 = Level1Item("基本语法")
        l0_1_1.addSubItem(ModuleFragment.PACKAGE_DEFINE_FRAGMENT)
        l0_1.addSubItem(l0_1_1)

        val l0_1_2 = Level1Item("习惯用语")
        l0_1.addSubItem(l0_1_2)
        val l0_1_3 = Level1Item("编码风格")
        l0_1.addSubItem(l0_1_3)
        data.add(l0_1)

        val l0_2 = Level0Item("基础")
        val l0_2_1 = Level1Item("基本类型")
        l0_2.addSubItem(l0_2_1)
        val l0_2_2 = Level1Item("包")
        l0_2.addSubItem(l0_2_2)
        val l0_2_3 = Level1Item("控制流")
        l0_2.addSubItem(l0_2_3)
        val l0_2_4 = Level1Item("返回与跳转")
        l0_2.addSubItem(l0_2_4)
        data.add(l0_2)

        val l0_3 = Level0Item("类和对象")
        val l0_3_1 = Level1Item("类和继承")
        l0_3.addSubItem(l0_3_1)
        val l0_3_2 = Level1Item("属性和字段")
        l0_3.addSubItem(l0_3_2)
        val l0_3_3 = Level1Item("接口")
        l0_3.addSubItem(l0_3_3)
        val l0_3_4 = Level1Item("可见性修饰词")
        l0_3.addSubItem(l0_3_4)
        val l0_3_5 = Level1Item("扩展")
        l0_3.addSubItem(l0_3_5)
        val l0_3_6 = Level1Item("数据对象")
        l0_3.addSubItem(l0_3_6)
        val l0_3_7 = Level1Item("泛型")
        l0_3.addSubItem(l0_3_7)
        val l0_3_8 = Level1Item("嵌套类")
        l0_3.addSubItem(l0_3_8)
        val l0_3_9 = Level1Item("枚举类")
        l0_3.addSubItem(l0_3_9)
        val l0_3_10 = Level1Item("对象表达式和声明")
        l0_3.addSubItem(l0_3_10)
        val l0_3_11 = Level1Item("代理模式")
        l0_3.addSubItem(l0_3_11)
        val l0_3_12 = Level1Item("代理属性")
        l0_3.addSubItem(l0_3_12)
        data.add(l0_3)

        val l0_4 = Level0Item("函数和lambda表达式")
        val l0_4_1 = Level1Item("函数")
        l0_4.addSubItem(l0_4_1)
        val l0_4_2 = Level1Item("高阶函数和lambda表达式")
        l0_4.addSubItem(l0_4_2)
        val l0_4_3 = Level1Item("内联函数")
        l0_4.addSubItem(l0_4_3)
        data.add(l0_4)

        val l0_5 = Level0Item("其他")
        val l0_5_1 = Level1Item("多重声明")
        l0_5.addSubItem(l0_5_1)
        val l0_5_2 = Level1Item("Ranges")
        l0_5.addSubItem(l0_5_2)
        val l0_5_3 = Level1Item("类型检查和自动转换")
        l0_5.addSubItem(l0_5_3)
        val l0_5_4 = Level1Item("This表达式")
        l0_5.addSubItem(l0_5_4)
        val l0_5_5 = Level1Item("等式")
        l0_5.addSubItem(l0_5_5)
        val l0_5_6 = Level1Item("运算符重载")
        l0_5.addSubItem(l0_5_6)
        val l0_5_7 = Level1Item("空安全")
        l0_5.addSubItem(l0_5_7)
        val l0_5_8 = Level1Item("异常")
        l0_5.addSubItem(l0_5_8)
        val l0_5_9 = Level1Item("注解")
        l0_5.addSubItem(l0_5_9)
        val l0_5_10 = Level1Item("反射")
        l0_5.addSubItem(l0_5_10)
        val l0_5_11 = Level1Item("动态类型")
        l0_5.addSubItem(l0_5_11)
        data.add(l0_5)

        mainAdapter?.setNewData(data)
    }

}