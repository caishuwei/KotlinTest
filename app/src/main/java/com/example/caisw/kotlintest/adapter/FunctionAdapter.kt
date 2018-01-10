package com.example.caisw.kotlintest.adapter

import android.view.View
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.example.caisw.kotlintest.R
import com.example.caisw.kotlintest.entities.FragmentData
import com.example.caisw.kotlintest.ui.base.FragmentOpenActivity

/**
 * Created by caisw on 2018/1/10.
 */
class FunctionAdapter : BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {


    constructor() : super(null) {
        addItemType(MultiItemEntityValue.TYPE_TITLE, R.layout.item_function_title)
        addItemType(MultiItemEntityValue.TYPE_CODE, R.layout.item_function_code)
        addItemType(MultiItemEntityValue.TYPE_FRAGMENT_DATA, R.layout.item_function_title)
    }

    override fun convert(helper: BaseViewHolder?, item: MultiItemEntity?) {
        if (helper != null && item != null) {
            when (helper.itemViewType) {
                MultiItemEntityValue.TYPE_TITLE ->
                    helper.setText(R.id.tv_title, item.toString())
                MultiItemEntityValue.TYPE_CODE ->
                    helper.setText(R.id.tv_code, item.toString())
                MultiItemEntityValue.TYPE_FRAGMENT_DATA -> {
                    var fd = item as FragmentData
                    helper.setText(R.id.tv_title, fd.title)
                    helper.getView<View>(R.id.tv_title).setOnClickListener { v ->
                        FragmentOpenActivity.openActivity(
                                v.context,
                                fd.className,
                                fd.data
                        )
                    }
                }
            }
        }
    }

}