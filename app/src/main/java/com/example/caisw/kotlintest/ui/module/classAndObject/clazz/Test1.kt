package com.example.caisw.kotlintest.ui.module.classAndObject.clazz

/**
 * 所有类默认继承Any ,与java的Object道理一样，提供了hashCode equals toString三个方法
 *
 * 类名后面可以定义主构造函数，在存在主构造函数时，次级构造函数必须继承主构造函数，
 * 参数可以作为该类的属性访问，参数可以使用修饰词，当使用了val或var时，其他类才可以访问，否则只有本类可以访问（相当于方法参数只有方法内可用）
 * Created by caisw on 2018/1/30.
 */
public open class Test1 constructor(val name: String, var code: Int = 1) {

    companion object {
        //伴生对象，kotlin没有静态属性与方法一说，因为属性、方法与类一样，可以顶级声明，直接属于包，而不属于类
        //但有时候又需要访问类里面的私有构造方法或私有变量之类的，于是又搞了个伴生对象（艹），在伴生对象代码块里面声明的属性与方法都属于可以静态访问的

        val VALUE_1 = "1"

        fun function_1(): String {
            return "方法1" + VALUE_1
        }
    }

    var n = name.toLowerCase()
    var v1: String = "变量" //主构造函数没有方法体，函数参数直接作为类变量可以访问
    val v2: String = "常量 等同于java final修饰"

    val f1 = Test1.function_1()//通过类名调用伴生方法

    /**
     * 定义次级构造函数，调用本类的其他构造函数的方式是this(构造参数)
     * 如果不需要在执行什么初始化代码，可以不要方法体
     */
    constructor(name: String, endStr: String) : this(name + endStr)

    /**
     * 定义次级构造函数,这个函数继承自另一个次级构造函数，这是允许的，只要最终有继承主构造函数即可
     */
    constructor() : this("", "") {
        v1 = "name is null"
    }

    //方法复写
    override fun toString(): String {
        return "v1 = $v1,v2 = $v2"
    }

    open fun print(){

    }

}