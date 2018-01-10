package com.example.caisw.kotlintest.entities

import android.os.Bundle
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.example.caisw.kotlintest.adapter.MultiItemEntityValue

/**
 * 列表项
 * Created by caisw on 2018/1/8.
 */
class FragmentData : MultiItemEntity {
    override fun getItemType(): Int {
        return MultiItemEntityValue.TYPE_FRAGMENT_DATA
    }

    //定义属性，默认是public(类的限定也是默认public),这里指定set方法私有，只能在构造时赋值
    var title: String
        private set
    var className: String
        private set
    var data: Bundle?
        private set

    constructor(displayText: String, className: String, data: Bundle?) {
        this.title = displayText
        this.className = className
        this.data = data
    }
}