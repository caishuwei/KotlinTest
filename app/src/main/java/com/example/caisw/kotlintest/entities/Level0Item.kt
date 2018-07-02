package com.example.caisw.kotlintest.entities

import com.chad.library.adapter.base.entity.AbstractExpandableItem
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.example.caisw.kotlintest.adapter.MultiItemEntityValue

/**
 * Created by caisw on 2018/1/9.
 */
class Level0Item : AbstractExpandableItem<FragmentData>, MultiItemEntity {

    var title: String
        private set

    constructor(title: String) : super() {
        this.title = title
    }

    override fun getLevel(): Int {
        return 0
    }

    override fun getItemType(): Int {
        return MultiItemEntityValue.TYPE_LEVEL_0
    }

}