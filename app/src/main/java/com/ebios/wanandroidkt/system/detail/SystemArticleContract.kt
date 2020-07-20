package com.ebios.wanandroidkt.system.detail

import com.ebios.wanandroidkt.base.mvp.IView
import com.ebios.wanandroidkt.home.bean.Article

interface SystemArticleContract {

    interface View : IView {
        fun onSystemArticles(page: Int, list: List<Article>?)
    }

    interface Presenter {
        fun getSystemArticles(page: Int, cid: Int)
    }

}