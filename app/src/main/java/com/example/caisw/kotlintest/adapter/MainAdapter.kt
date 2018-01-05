package com.example.caisw.kotlintest.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.caisw.kotlintest.R

/**
 *  类的泛型也是同java，加于类名之后
 * Created by caisw on 2018/1/4.
 */
class MainAdapter : BaseQuickAdapter<String, BaseViewHolder> {

    constructor() : super(R.layout.item_main) {

    }

    override fun convert(helper: BaseViewHolder?, item: String?) {
        //kotlin的安全访问，变量加上问号，如果未空不执行后面的方法调用
        helper?.setText(R.id.tv_item_text, item)
    }

}