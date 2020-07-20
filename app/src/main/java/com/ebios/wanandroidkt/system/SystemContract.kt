package com.ebios.wanandroidkt.system

import com.ebios.wanandroidkt.base.mvp.IView
import com.ebios.wanandroidkt.system.bean.SystemCategory

interface SystemContract {
    interface View :IView{
        fun onSystemCategory(data: List<SystemCategory>?)
    }

    interface Presenter {
        /**
         * 获取系统分类
         */
        fun getSystemCategory()
    }
}