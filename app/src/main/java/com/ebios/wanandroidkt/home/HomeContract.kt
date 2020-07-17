package com.ebios.wanandroidkt.home

import com.ebios.wanandroidkt.base.mvp.IView
import com.ebios.wanandroidkt.home.bean.Article
import com.ebios.wanandroidkt.home.bean.Banner

interface HomeContract {

    interface View : IView {

        fun onBanner(list: List<Banner>?)

        fun onArticles(page: Int, list: List<Article>?)
    }

    interface Presenter {

        fun getBanner()

        fun getArticles(page: Int)

    }
}