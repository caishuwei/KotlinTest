package com.example.caisw.kotlintest.ui.module.basics.packages

//包导入
//单独导入包中的某个类，变量，方法。。。。。。

import DefaultPackageClass

class Test2 {
    var pv: String = packageVar
    var pf: String = packageFun()
    var pI: PackageInterface? = null
    var pc: PackageClass = PackageClass()
    var dc: DefaultPackageClass = DefaultPackageClass()
}