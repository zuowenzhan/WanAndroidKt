package com.ebios.wanandroidkt.system

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.ebios.wanandroidkt.R
import com.ebios.wanandroidkt.system.bean.SystemCategory

class SystemContentAdapter (layoutResId: Int) : BaseQuickAdapter<SystemCategory, BaseViewHolder>(layoutResId) {

    override fun convert(helper: BaseViewHolder?, item: SystemCategory?) {
        helper?.setText(R.id.tv_system_category, item?.name)
    }
}