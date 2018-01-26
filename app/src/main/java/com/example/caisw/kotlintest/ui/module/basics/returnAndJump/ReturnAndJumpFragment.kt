package com.example.caisw.kotlintest.ui.module.basics.returnAndJump

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.example.caisw.kotlintest.entities.FunctionTitle
import com.example.caisw.kotlintest.ui.module.ModuleFragment

/**
 * Created by caisw on 2018/1/26.
 */
class ReturnAndJumpFragment : ModuleFragment() {

    override fun initData() {
        super.initData()
        val listData: MutableList<MultiItemEntity> = mutableListOf()
        listData.add(FunctionTitle("""
            |Kotlin 有三种结构跳转表达式：
            |   return      结束方法执行
            |   break       结束最近的闭合循环
            |   continue    跳到最近的闭合循环的下一次循环
        """.trimMargin()))

        break_continue(listData, 1)

        updateFunctionContent(listData)

    }

    private fun break_continue(listData: MutableList<MultiItemEntity>, i: Int) {
        listData.add(FunctionTitle("""
            |break用于结束循环，当多层循环嵌套时，可以用@标记循环，然后break@标记名称，即可跳出该循环
        """.trimMargin()))
        listData.add
    }

}