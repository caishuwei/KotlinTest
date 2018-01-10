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