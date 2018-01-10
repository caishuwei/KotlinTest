package com.example.caisw.kotlintest.entities

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.example.caisw.kotlintest.adapter.MultiItemEntityValue

/**
 * Created by caisw on 2018/1/10.
 */
class FunctionTitle :MultiItemEntity{

    var title:String = ""

    constructor(title: String) {
        this.title = title
    }

    override fun getItemType(): Int {
        return MultiItemEntityValue.TYPE_TITLE
    }

    override fun toString(): String {
        return title
    }
}