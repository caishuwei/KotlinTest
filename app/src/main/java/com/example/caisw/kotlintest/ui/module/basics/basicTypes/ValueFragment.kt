package com.example.caisw.kotlintest.ui.module.basics.basicTypes

import android.support.annotation.IntegerRes
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.example.caisw.kotlintest.entities.FunctionCode
import com.example.caisw.kotlintest.entities.FunctionTitle
import com.example.caisw.kotlintest.ui.module.ModuleFragment
import com.example.caisw.kotlintest.util.StringUtils

/**
 * Created by caisw on 2018/1/15.
 */
class ValueFragment : ModuleFragment() {

    override fun initData() {
        super.initData()
        val listData: MutableList<MultiItemEntity> = mutableListOf()
        listData.add(FunctionTitle("数值"))
        listData.add(FunctionTitle("1、6个内建类型（字符在kotlin中不属于数值类型）"))
        listData.add(FunctionCode("""
${StringUtils.appendSpaceAfter("类型")}${StringUtils.appendSpaceAfter("位宽")}
${StringUtils.appendSpaceAfter("Double")}${StringUtils.appendSpaceAfter("64")}
${StringUtils.appendSpaceAfter("Float")}${StringUtils.appendSpaceAfter("32")}
${StringUtils.appendSpaceAfter("Long")}${StringUtils.appendSpaceAfter("64")}
${StringUtils.appendSpaceAfter("Int")}${StringUtils.appendSpaceAfter("32")}
${StringUtils.appendSpaceAfter("Short")}${StringUtils.appendSpaceAfter("16")}
${StringUtils.appendSpaceAfter("Byte")}${StringUtils.appendSpaceAfter("8")}
        """.trimIndent()))

        listData.add(FunctionTitle("2、数值表示"))
        var int: Int = 1000//十进制整数
        var int16: Int = 0x0f//十六进制整数
        var int2: Int = 0b00001111//二进制整数
        var long: Long = 1000L//长整型
        var double: Double = 1000.0//长整型
        var float: Float = 1000.0F//长整型
        listData.add(FunctionCode("""
var int: Int = 1000//十进制整数
var int16: Int = 0x0f//十六进制整数
var int2: Int = 0b00001111//二进制整数
var long: Long = 1000L//长整型
var double: Double = 1000.0//长整型
var float: Float = 1000.0F//长整型
        """.trimIndent()))

        listData.add(FunctionTitle("3、增加可读性"))
        var spaceLine: Int = 999_999_999//使用下划线增加数值常量可读性
        listData.add(FunctionCode("""
var spaceLine:Int = 999_999_999//使用下划线增加数值常量可读性
        """.trimIndent()))

        boxing(listData, 4)

        conversion(listData, 5)

        operator(listData, 6)

        char(listData, 7)

        boolean(listData, 8)

        array(listData, 9)

        string(listData, 10)

        updateFunctionContent(listData)
    }

    private fun string(listData: MutableList<MultiItemEntity>, titleIndex: Int) {
        listData.add(FunctionTitle("""
$titleIndex、字符串String
        字符串
        """.trimMargin()))
        val text1 = "等同于java的字符串，\n分行使用转义的\\n"
        val text2 = """
    |多行字符串，同Python
    |可以不转义换行
    |trimMargin方法可以去除每行前面的缩进
    |默认采用|标注起始前缀，如果需要使用其他起始前缀，比如<，可以使用trimMargin("<")
    """.trimMargin()

        listData.add(FunctionCode("""
$text1

$text2

kotlin支持字符串模板（常用于生成动态网页），在字符串中使用${'$'}变量名插入变量值（toString）
使用 ${"$ {代码}"}则可以调用方法，将返回的字符串插入字符串模板中
        """.trimIndent()))
    }

    /**
     * 数组
     */
    private fun array(listData: MutableList<MultiItemEntity>, titleIndex: Int) {
        listData.add(FunctionTitle("""
$titleIndex、数组Array
        数组在 Kotlin 中由 Array 类表示，有 get 和 set （通过运算符重载为[] ）方法，和 size 属性
        """.trimMargin()))

        val arr = Array<Int>(3, { index -> index + 1 })
        arr[0] = 10
        arr[1] = 2

        val mutableArr = mutableListOf<Int>()
        mutableArr.add(10)
        mutableArr.add(2)

        fun printArr(arr: Array<Int>): String {
            val sb = StringBuilder()
            sb.append("[")
            val size = arr.size
            for (i in 0 until size) {
                sb.append(arr[i])
                if (i != size - 1) {
                    sb.append(",")
                }
            }
            sb.append("]")
            return sb.toString()
        }

        listData.add(FunctionCode("""
1、数组（相当于java的数组）
        val arr = Array<Int>(3,{index->index+1})
        arr[0] = 10
        arr[1] = 2
arr.size:${arr.size}
arr:${printArr(arr)}

2、动态数组（相当于java的ArrayList）
        val mutableArr = mutableListOf<Int>()
        mutableArr.add(10)
        mutableArr.add(2)
mutableArr.size:${mutableArr.size}
mutableArr:$mutableArr

3、为防止过度装箱，kotlin提供了几个基本数据类型的数组类
ByteArray, ShortArray, IntArray
可以使用intArrayOf()等方法构建
        """.trimIndent()
        ))
        intArrayOf()
    }


    /**
     * 布尔值
     */
    private fun boolean(listData: MutableList<MultiItemEntity>, titleIndex: Int) {
        listData.add(FunctionTitle("""
$titleIndex、布尔值Boolean
        与java一样，boolean只有true与false
        如果是可空类型Boolean?会被装箱
        """.trimMargin()))
        var t1 = true
        var t2 = true
        var f1 = false
        listData.add(FunctionCode("""
        var t1 = true
        var t2 = true
        var f1 = false

短路与
t1&&t2：${t1 && t2}

短路或
t1||f1：${t1 || f1}

取反
!t1：${!t1}

        """.trimIndent()))

    }

    /**
     * 字符
     */
    private fun char(listData: MutableList<MultiItemEntity>, titleIndex: Int) {
        listData.add(FunctionTitle("""
$titleIndex、字符Char
        字符不属于数值类型，不能使用 char == 1去与数值类型进行比较
        可以显示转换为数值类型再去比较
        """.trimMargin()))
        var char = 'a'
        listData.add(FunctionCode("""
        var char = 'a'
char强转为Int类型：${char.toInt()}

char.toInt() == 97 ? ${char.toInt() == 97}

        """.trimIndent()))

    }

    /**
     * 运算符
     */
    private fun operator(listData: MutableList<MultiItemEntity>, titleIndex: Int) {
        listData.add(FunctionTitle("""
$titleIndex、运算符
         除了常见的加减乘除运算，Int和Long类型还支持位运算符
        """.trimMargin()))
        var i: Int = Int.MIN_VALUE or 7
        var i2 = i.shl(1)//有符号左移
        var i3 = i shl 1//可以采用中缀形式调用，等同于java的<<，这种写法简单，但kotlin难道是为了与java不同而特地定义这些乱七八糟的东西？闲得蛋疼
        var i4 = i shr 1//有符号右移
        var i5 = i ushr 1//无符号右移
        var i6 = i and 0b1111//按位与
        var i7 = i or 0b111111//按位或
        var i8 = i xor 0b111111//按位异或
        var i9 = i.inv()//按位取反

        listData.add(FunctionCode("""
        var i:Int = Int.MIN_VALUE or 7
${outputFormat(i)}

        var i2 = i.shl(1)//有符号左移
        var i3 = i shl 1//可以采用中缀形式调用，等同于java的<<，这种写法简单，但kotlin难道是为了与java不同而特地定义这些乱七八糟的东西？闲得蛋疼
${outputFormat(i2)}

        var i4 = i shr 1//有符号右移
${outputFormat(i4)}

        var i5 = i ushr 1//无符号右移
${outputFormat(i5)}

        var i6 = i and 0b1111//按位与
${outputFormat(i6)}

        var i7 = i or 0b111111//按位或
${outputFormat(i7)}

        var i8 = i xor 0b111111//按位异或
${outputFormat(i8)}

        var i9 = i.inv()//按位取反
${outputFormat(i9)}
        """.trimIndent()))
    }

    private fun outputFormat(num: Int): String {
        val sb = StringBuilder()
        var msg = Integer.toBinaryString(num)
        if (msg.length < 32) {
            for (i in 0 until 32 - msg.length) {
                sb.append("0")
            }
            sb.append(msg)
            msg = sb.toString()
        }
        return msg
    }


    /**
     * 显示转换
     */
    private fun conversion(listData: MutableList<MultiItemEntity>, titleIndex: Int) {
        listData.add(FunctionTitle("""
$titleIndex、显示转换
        由于Long不是Int的子类，所以不存在隐式转换。
        他们继承自Number类，实现7个基本类型（包含Char）之间的转换方法（toXxxx()）
        """.trimMargin()))
        var int: Int = 1000
        var long: Long = int.toLong()
        var float: Float = int.toFloat()
        var double: Double = float.toDouble()

        listData.add(FunctionCode("""
var int:Int =  1000
var long:Long = int.toLong()
var float:Float = int.toFloat()
var double:Double = float.toDouble()
        """.trimIndent()))

    }

    /**
     * 装箱
     */
    private fun boxing(listData: MutableList<MultiItemEntity>, titleIndex: Int) {
        listData.add(FunctionTitle("""
$titleIndex、装箱
        在 java 平台上，数值被 JVM 虚拟机以字节码的方式物理存储的，除非我们需要做可空标识(比如说 Int?) 或者涉及泛型。在后者中数值是装箱过的。
        """.trimMargin()))

        var int_1 = 1000//常见的整型，自动判断类型为Int
        var int_2: Int? = int_1 //可空类型会被装箱，这是一个新的对象
        var int_3: Int? = int_1 //可空类型会被装箱，这是一个新的对象
        listData.add(FunctionCode("""
var int_1 = 1000//常见的整型，自动判断类型为Int
var int_2:Int? = int_1 //可空类型会被装箱，这是一个新的对象
var int_3:Int? = int_1 //可空类型会被装箱，这是一个新的对象

int_2 === int_3 ? ${int_2 === int_3}
        """.trimIndent()))

    }
}