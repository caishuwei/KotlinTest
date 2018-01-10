package com.example.caisw.kotlintest.adapter

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.example.caisw.kotlintest.R
import com.example.caisw.kotlintest.entities.FragmentData
import com.example.caisw.kotlintest.entities.Level0Item
import com.example.caisw.kotlintest.entities.Level1Item

/**
 *  类的泛型也是同java，加于类名之后
 * Created by caisw on 2018/1/4.
 */
class MainAdapter<T : MultiItemEntity> : BaseMultiItemQuickAdapter<T, BaseViewHolder> {

    companion object {
    }

    constructor() : super(null) {
        addItemType(MultiItemEntityValue.TYPE_LEVEL_0, R.layout.item_main_1)
        addItemType(MultiItemEntityValue.TYPE_LEVEL_1, R.layout.item_main_2)
        addItemType(MultiItemEntityValue.TYPE_FRAGMENT_DATA, R.layout.item_main_3)
    }

    override fun convert(helper: BaseViewHolder?, item: T) {
        if (helper != null) {
            //使用when替代了java的switch,也可以替代if else使用，when支持更多操作
            when (helper.itemViewType) {
                MultiItemEntityValue.TYPE_LEVEL_0 -> helper.setText(R.id.tv_item_text, (item as Level0Item).title)
                MultiItemEntityValue.TYPE_LEVEL_1 -> helper.setText(R.id.tv_item_text, (item as Level1Item).title)
                MultiItemEntityValue.TYPE_FRAGMENT_DATA -> helper.setText(R.id.tv_item_text, (item as FragmentData).title)
            }
        }
    }

}