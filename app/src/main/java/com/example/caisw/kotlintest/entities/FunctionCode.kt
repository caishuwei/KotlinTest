package com.example.caisw.kotlintest.entities

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.example.caisw.kotlintest.adapter.MultiItemEntityValue

/**
 * Created by caisw on 2018/1/10.
 */
class FunctionCode : MultiItemEntity {
    var code: String = ""

    constructor(code: String) {
        this.code = code
    }

    override fun getItemType(): Int {
        return MultiItemEntityValue.TYPE_CODE
    }

    override fun toString(): String {
        return code
    }
}