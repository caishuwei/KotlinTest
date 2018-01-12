// 1、Kotlin的包结构不依赖于kotlin文件所在的目录结构，而是直接通过包定义语句定义,也就是说所有的kotlin文件可以存放到同一个文件夹中而不会影响包结构
// 2、包下面可以直接定义属于包的变量、方法、接口、类
// 3、与java不同，Kotlin文件名可以随便起，一个Kotlin文件内部可以包含一个包的所有东西（比如多个类，当然不建议这么写）
// 4、不定义包名的话，属于default包，导入时直接import 类名就可以了
package com.example.caisw.kotlintest.ui.module.basics.packageDefine

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