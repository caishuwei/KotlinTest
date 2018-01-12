package com.example.caisw.kotlintest.ui.module.basics.function

/**
 * Created by caisw on 2018/1/11.
 */
class Test : Any() {

    //1、通过：限定符 fun 函数名(参数名:参数类型,参数名:参数类型....):返回类型{}定义函数
    //kotlin空安全 参数类型后面加问号表示该参数可以为空值（null），返回类型加了问号表示可能返回null
    //如果一个函数不返回值，可以返回Unit，Unit可以省略
    private fun test(p1: String, p2: String, p3: Int?): Unit {

    }

    //2、函数复写使用限定符override（java使用@Override注解标记函数复写）
    override fun toString(): String {
        return super.toString()
    }

    //3、参数默认值
    /**
     * @param p1 参数1
     * @param p2 参数2 默认值-1
     * @param p3 参数3 默认值参数3
     */
    fun defaultValueSupport(p1: String, p2: Int = -1, p3: String = "参数3") {

        //调用时带有默认值的参数可以不传
        defaultValueSupport("参数1")

        //存在多个默认的参数的情况下,如果有部分默认参数不打算传值，那么可以使用命名参数
        //的方式进行传值，也就是以参数名= 参数值方式进行参数赋值
        //注意！命名参数调用方式，不可以用于调用java函数（java字节码不能保证参数名不变）
        defaultValueSupport("参数1", p3 = "参数3")
    }

    //4、单表达式函数
    fun double(x: Int): Int = x * 2

    //如果编译器可以自行推导返回值类型可以不用写类型
    // (建议还是写，看起来方便点，而且你有可能是返回父类或接口类型，但自动推导会返回子类类型)
    fun double2(x: Int) = x * 2

    //5、可变参函数，与java的可变参函数一样，可以传入一个数组的数据，只是表现方式不同
    fun toStringList(vararg p1: Any): MutableList<String> {
        val list = mutableListOf<String>()
        for (obj in p1) {
            list.add(obj.toString())
        }
        return list
    }

    //6、函数范围
    //6.1、局部函数
    fun outer(): String? {
        fun inner(name: String?): Boolean {
//                return@outer ""
            return name == "csw"
        }
        val un = "csw"
        var b = inner(un)
       return null
    }


}