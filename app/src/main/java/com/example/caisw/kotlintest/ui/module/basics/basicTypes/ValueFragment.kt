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

        updateFunctionContent(listData)
    }

    private fun operator(listData: MutableList<MultiItemEntity>, titleIndex: Int) {
        listData.add(FunctionTitle("""
$titleIndex、运算符
         除了常见的加减乘除运算，Int和Long类型还支持位运算符
        """.trimMargin()))
        var i:Int = Int.MIN_VALUE or 7
        var i2 = i.shl(1)//有符号左移
        var i3 = i shl 1//可以采用中缀形式调用，等同于java的<<，这种写法简单，但kotlin难道是为了与java不同而特地定义这些乱七八糟的东西？闲得蛋疼
        var i4 = i shr 1//有符号右移
        var i5 = i ushr 1//无符号右移
        var i6 = i and 0b1111//按位与
        var i7 = i or 0b111111//按位或
        var i8 = i xor 0b111111//按位异或
        var i9 = i.inv()//按位取反

        listData.add(FunctionCode("""
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