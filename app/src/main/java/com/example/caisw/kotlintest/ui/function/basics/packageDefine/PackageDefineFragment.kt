package com.example.caisw.kotlintest.ui.function.basics.packageDefine

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.example.caisw.kotlintest.entities.FunctionCode
import com.example.caisw.kotlintest.entities.FunctionTitle
import com.example.caisw.kotlintest.ui.function.FunctionFragment

/**
 * 包定义
 * Created by caisw on 2018/1/9.
 */
class PackageDefineFragment : FunctionFragment() {

    override fun initData() {
        super.initData()
        val listData :MutableList<MultiItemEntity> = mutableListOf()
        listData.add(FunctionTitle("1、Kotlin的包结构不依赖于kotlin文件所在的目录结构，而是直接通过包定义语句定义,也就是说所有的kotlin文件可以存放到同一个文件夹中而不会影响包结构"))
        listData.add(FunctionTitle("2、包下面可以直接定义属于包的变量、方法、接口、类"))
        listData.add(FunctionTitle("3、与java不同，Kotlin文件名可以随便起，一个Kotlin文件内部可以包含一个包的所有东西（比如多个类，当然不建议这么写）"))
        listData.add(FunctionTitle("4、不定义包名的话，属于default包，导入时直接import 类名就可以了\n"))

        listData.add(FunctionTitle("定义一个包"))
        listData.add(FunctionCode("""
//包名定义
package com.example.caisw.kotlintest.ui.function.basics.packageDefine

//定义一个属于包的变量
var packageVar :String = "com.example.caisw.kotlintest.ui.function.basics.package.getPackageVar"

//定义一个属于包的方法
fun packageFun ():String{
    return "com.example.caisw.kotlintest.ui.function.basics.package.packageFun()"
}

//定义一个属于包的接口
interface PackageInterface {

    fun interfaceFun()

}

//定义一个属于包的类
class PackageClass {

    constructor(){
    }
}
        """.trimIndent()))

        listData.add(FunctionTitle("在default包定义一个class(不定义包)"))
        listData.add(FunctionCode("""

class DefaultPackageClass {

}

        """.trimIndent()))

        listData.add(FunctionTitle("包的成员（属性，方法，接口，类）导入"))
        listData.add(FunctionCode("""
package com.example.caisw.kotlintest.ui.function.basics.packageDefine

//包导入
import com.example.caisw.kotlintest.ui.function.basics.packageDefine.*
//单独导入包中的某个类，变量，方法。。。。。。
import com.example.caisw.kotlintest.ui.function.basics.packageDefine.packageVar
import com.example.caisw.kotlintest.ui.function.basics.packageDefine.packageFun
import com.example.caisw.kotlintest.ui.function.basics.packageDefine.PackageInterface
import com.example.caisw.kotlintest.ui.function.basics.packageDefine.PackageClass

import DefaultPackageClass

class Test2 {
    var pv: String = packageVar
    var pf: String = packageFun()
    var pI: PackageInterface? = null
    var pc: PackageClass = PackageClass()
    var dc: DefaultPackageClass = DefaultPackageClass()
}

        """.trimIndent()))

        updateFunctionContent(listData)
    }

}