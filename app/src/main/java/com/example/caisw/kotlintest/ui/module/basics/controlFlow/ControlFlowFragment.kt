package com.example.caisw.kotlintest.ui.module.basics.controlFlow

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.example.caisw.kotlintest.entities.FunctionCode
import com.example.caisw.kotlintest.entities.FunctionTitle
import com.example.caisw.kotlintest.ui.module.ModuleFragment

/**
 * Created by caisw on 2018/1/23.
 */
class ControlFlowFragment : ModuleFragment() {

    override fun initData() {
        super.initData()
        val listData: MutableList<MultiItemEntity> = mutableListOf()

        biaodashi_if(listData, 1)
        biaodashi_when(listData, 2)
        biaodashi_for(listData, 3)

        updateFunctionContent(listData)
    }

    private fun biaodashi_for(listData: MutableList<MultiItemEntity>, i: Int) {

    }

    private fun biaodashi_when(listData: MutableList<MultiItemEntity>, i: Int) {
        listData.add(FunctionTitle("""
            |$i、when表达式
            |       kotlin使用when表达式替代java switch的作用,java switch只支持整型枚举字符串，when表达式则显得更人性化
        """.trimMargin()))

        val v = 1

        val msg = when (v) {
            1, 2 -> "值是1或者是2"
            else -> "非法值"
        }

        val msg2 = when (v) {
            Integer.parseInt("1", 10) -> "值是1"
            else -> "非法值"
        }

        val list = List(10, { index -> index })//创建0~9的一个集合
        val range = 10..15//创建一个范围10~15

        val msg3 = when (v) {
            in list -> "值在列表中"
            in range -> "值在范围中"
            else -> "非法值"
        }
        val v10 = 10
        val msg4 = when (v10) {
            in list -> "值在列表中"
            in range -> "值在范围中"
            else -> "非法值"
        }

        val msg5 = when (v) {
            is Int -> "整型 $v"
            else -> "类型错误"
        }

        val msg6 = when {
            v is Int -> "整型 $v"
            else -> "类型错误"
        }
        listData.add(FunctionCode("""
            |when表达式也同if表达式一样，可以用于返回
            |       val v = 1
            |       val msg = when(v){
            |           1,2->"值是1或者是2"
            |           else->"非法值"
            |       }
            |
            |msg : $msg
            |
            |
            |使用表达式作为分支条件
            |       val msg2 = when(v){
            |           Integer.parseInt("1",10)->"值是1"
            |           else->"非法值"
            |       }
            |
            |msg2 : $msg2
            |
            |
            |使用in 或!in 判断是否在一个范围或集合中
            |
            |       val list = List(10,{index->index})//创建0~9的一个集合
            |       val range = 10..15//创建一个范围10~15
            |       val msg3 = when(v){
            |           in list->"值在列表中"
            |           in range->"值在范围中"
            |           else->"非法值"
            |       }
            |       val v10 = 10
            |       val msg4 = when(v10){
            |           in list->"值在列表中"
            |           in range->"值在范围中"
            |           else->"非法值"
            |       }
            |
            |msg3 : $msg3
            |msg4 : $msg4
            |
            |
            |使用 is 或 !is 判断类型
            |
            |        val msg5 = when(v){
            |            is Int->"整型 ${"\$v"}"
            |            else->"类型错误"
            |        }
            |
            |msg5 : $msg5
            |
            |
            |不使用参数，当条件boolean值成立则分支运行
            |
            |        val msg6 = when {
            |            v is Int -> "整型 ${"\$v"}"
            |            else -> "类型错误"
            |        }
            |
            |msg6 : $msg6
        """.trimMargin()))
    }

    private fun biaodashi_if(listData: MutableList<MultiItemEntity>, i: Int) {
        listData.add(FunctionTitle("""
            $i、if表达式
        """.trimIndent()))
        val b = true
        val value = if (b) "b为true" else "b为false"
        val value2 = if (b) {
            var i = 1
            i++
            "$i"//最后一行代码用于返回值
        } else {
            "else"
        }
        listData.add(FunctionCode("""
            |if表达式带有返回值，可以替代三元运算符
            val b = true
            val value = if (b) "b为true" else "b为false"

            |value:$value

            |也可以使用执行语句块后返回表达式的值
            val value2 = if(b){
                var i = 1
                i++
                ${"\"\$i\""}//最后一行代码用于返回值
            }else{
                "else"
            }

            |value2:$value2

        """.trimMargin()))
    }

}