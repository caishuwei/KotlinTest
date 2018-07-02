package com.example.caisw.kotlintest.ui.module.basics.returnAndJump

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.example.caisw.kotlintest.entities.FunctionCode
import com.example.caisw.kotlintest.entities.FunctionTitle
import com.example.caisw.kotlintest.ui.module.ModuleFragment
import java.lang.StringBuilder

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
            |   continue    跳到最近的闭合循环的下一步
        """.trimMargin()))

        break_(listData, 1)
        continue_(listData, 2)
        return_(listData, 3)

        updateFunctionContent(listData)

    }

    private fun return_(listData: MutableList<MultiItemEntity>, i: Int) {
        listData.add(FunctionTitle("""
            |$i、return 用于方法返回
        """.trimMargin()))

        listData.add(FunctionCode("""
            |        val sb = StringBuilder()
            |        for (a in 0..10) {
            |            if (a == 5) {
            |                //输出sb内容（代码省略，在这里已经return，会输出0~4）
            |                return
            |            }
            |            sb.append("${"\$a "}")
            |            sb.append("\n")
            |        }
            |        //输出sb内容（代码省略 ，如果能走到这里，会输出0~10）
            |

        """.trimMargin()))

        val sb = StringBuilder()
        for (a in 0..10) {
            if (a == 5) {
                listData.add(FunctionCode("${sb.toString()}"))
                return
            }
            sb.append("$a ")
            sb.append("\n")
        }
        listData.add(FunctionCode("${sb.toString()}"))
    }

    private fun continue_(listData: MutableList<MultiItemEntity>, i: Int) {
        listData.add(FunctionTitle("""
            |$i、continue 用于跳到最近闭合循环的下一步
        """.trimMargin()))
        val sb = StringBuilder()
        for (a in 0..10) {
            if (a == 5) continue
            sb.append("$a ")
            sb.append("\n")
        }

        listData.add(FunctionCode("""
            |        for (a in 0..10) {
            |            if (a == 5) continue
            |            sb.append("${"\$a "}")
            |            sb.append("\n")
            |        }
            |
            |${sb.toString()}
        """.trimMargin()))

    }

    private fun break_(listData: MutableList<MultiItemEntity>, i: Int) {
        listData.add(FunctionTitle("""
            |$i、break 用于结束循环，当多层循环嵌套时，可以用@标记循环，然后break@标记名称，即可跳出该循环
        """.trimMargin()))

        val sb = StringBuilder()
        loop1@ for (a in 0..10) {
            for (j in 0 until 10) {
                if (a == 10) {
                    break@loop1
                }
                if (j > a) {
                    break
                }
                sb.append("$a$j ")
            }
            sb.append("\n")
        }

        listData.add(FunctionCode("""
            |        val sb = StringBuilder()
            |        loop1@ for (a in 0 .. 10) {
            |            for (j in 0 until 10) {
            |                if(a == 10){
            |                    break@loop1
            |                }
            |                if(j>a){
            |                    break
            |                }
            |                sb.append("${"\$a\$j "}")
            |            }
            |            sb.append("\n")
            |        }
            |
            |${sb.toString()}
        """.trimMargin()))
    }

}