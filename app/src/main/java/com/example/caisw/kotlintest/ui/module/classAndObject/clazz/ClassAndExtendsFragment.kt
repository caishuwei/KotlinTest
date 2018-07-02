package com.example.caisw.kotlintest.ui.module.classAndObject.clazz

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.example.caisw.kotlintest.entities.FunctionCode
import com.example.caisw.kotlintest.entities.FunctionTitle
import com.example.caisw.kotlintest.ui.module.ModuleFragment
import java.lang.StringBuilder

/**
 * 类和继承
 * Created by caisw on 2018/1/30.
 */
class ClassAndExtendsFragment : ModuleFragment() {

    override fun initData() {
        super.initData()
        val listData: MutableList<MultiItemEntity> = mutableListOf()

        class_(listData, 1)
        extends_(listData, 2)
        callFunctionWithSameName(listData, 3)


        updateFunctionContent(listData)
    }

    private fun callFunctionWithSameName(listData: MutableList<MultiItemEntity>, i: Int) {
        listData.add(FunctionTitle("""
            |$i、实现的接口或父类甚至本类有相同方法时如何调用
            |       在java中，如果要实现的接口有相同名称相同参数相同返回值的方法，就当做已经实现了改接口方法，理论上方法名称相同，参数相同，返回值相同，那么这个方法的功能应该也相同，可以视为一个方法
            |       但实际命名中，对接口方法的命名并不那么明确，有可能导致重复，比如一个动物如Cat类，有run方法用于让小猫奔跑时调用，但如果同时实现了Runnable接口就出现了歧义，到底是实现奔跑还是实现异步任务
            |       kotlin对此也做出了明确的规范，用于调用父类和接口的重复方法
        """.trimMargin()))


    }

    private fun extends_(listData: MutableList<MultiItemEntity>, i: Int) {

        listData.add(FunctionTitle("""
            |$i、类的继承
            |      若一个类没有声明继承的父类，那么这个类默认继承自kotlin的Any
            |      可以使用is关键字判断一个对象是否是该类的实现类
        """.trimMargin()))

        val v = StringBuilder().append("java字符串").toString()
        val v2 = listOf<String>()
        listData.add(FunctionCode("""
            |Object与Any
            |        val v = StringBuilder().append("java字符串").toString()
            |        val v2 = listOf<String>()
            |
            |v is Any :${v is Any} 显然kotlin做了处理，对于java的基类Object,is Any同样判断为true，不会出现Object和Any的两个父类的情况
            |v2 is Any :${v2 is Any}
            |
            |还有就是Object类在kotlin中是找不到引用的。。。
        """.trimMargin()))

        listData.add(FunctionCode("""
            |在kotlin中对类继承与方法复写需要有明确的标识
            |使用open修饰的类和方法才能被继承与复写
            |
            |open class Base {
            |   open fun v() {}
            |   fun nv() {}
            |}
            |
            |class Derived() : Base() {
            |   override fun v() {}
            |}
            |
            |open关键字起到的作用：
            |       对比java,方法如果是public protected修饰的，可以被继承够复写，但有时我们只是想让别人能够调用，而不想让人复写
            |       kotlin此举将调用与复写分开，使用可见性修饰词描述调用权限，使用open描述可复写，确实比较明确
        """.trimMargin()))
    }

    private fun class_(listData: MutableList<MultiItemEntity>, i: Int) {
        listData.add(FunctionTitle("""
            |$i、声明一个类
        """.trimMargin()))

        listData.add(FunctionCode("""
            |修饰符 class 类名 类头{
            |    属性声明
            |    方法声明
            |}
            |
            |修饰符：public(默认值，对所有类可见) private(与java相同，只有本源文件中可见，可以用于修饰内部类，让外部类无法访问) protected(与private类似，但子类可见) internal(java的可见性默认修饰词，同个包可见)
            |class：关键字，用于声明一个类
            |类名：类名称，规范驼峰命名法
            |类头：包含继承、主构造函数声明等，如果没有可以省略
            |类体：用于属性和函数声明，如果没有可以省略类体
            |也就是一个类可以简略到只剩下 class 类名
            |
            |
            |/**
            | * 所有类默认继承Any ,与java的Object道理一样，提供了hashCode equals toString三个方法
            | *
            | * 类名后面可以定义主构造函数，在存在主构造函数时，次级构造函数必须继承主构造函数，
            | * 参数可以作为该类的属性访问，参数可以使用修饰词，当使用了val或var时，其他类才可以访问，否则只有本类可以访问（相当于方法参数只有方法内可用）
            | * Created by caisw on 2018/1/30.
            | */
            |public class Test1 constructor(val name: String,var code: Int = 1) {
            |    companion object {
            |        //伴生对象，kotlin没有静态属性与方法一说，因为属性、方法与类一样，可以顶级声明，直接属于包，而不属于类
            |        //但有时候又需要访问类里面的私有构造方法或私有变量之类的，于是又搞了个伴生对象（艹），在伴生对象代码块里面声明的属性与方法都属于可以静态访问的
            |        val VALUE_1 = "1"
            |        fun function_1(): String {
            |            return "方法1" + VALUE_1
            |        }
            |    }
            |    var n = name.toLowerCase()
            |    var v1: String = "变量" //主构造函数没有方法体，函数参数直接作为类变量可以访问
            |    val v2: String = "常量 等同于java final修饰"
            |    val f1 = Test1.function_1()//通过类名调用伴生方法
            |    /**
            |     * 定义次级构造函数，调用本类的其他构造函数的方式是this(构造参数)
            |     * 如果不需要在执行什么初始化代码，可以不要方法体
            |     */
            |    constructor(name: String, endStr: String) : this(name + endStr)
            |    /**
            |     * 定义次级构造函数,这个函数继承自另一个次级构造函数，这是允许的，只要最终有继承主构造函数即可
            |     */
            |    constructor() : this("", "") {
            |        v1 = "name is null"
            |    }
            |    //方法复写
            |    override fun toString(): String {
            |        return "v1 = ${"\$v1"},v2 = ${"\$v2"}"
            |    }
            |}
            |
        """.trimMargin()))
    }

}