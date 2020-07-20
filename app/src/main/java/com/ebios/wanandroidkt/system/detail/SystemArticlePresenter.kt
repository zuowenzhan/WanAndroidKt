package com.ebios.wanandroidkt.system.detail

import com.ebios.wanandroidkt.api.ApiService
import com.ebios.wanandroidkt.base.mvp.BasePresenter
import com.ebios.wanandroidkt.home.bean.ArticleResponse
import com.ebios.wanandroidkt.net.BaseObserver

class SystemArticlePresenter : BasePresenter<SystemArticleContract.View>(), SystemArticleContract.Presenter {

    override fun getSystemArticles(page: Int, cid: Int) {
        addSubscribe(create(ApiService::class.java).getSystemArticles(page, cid),
            object : BaseObserver<ArticleResponse>() {
                override fun onSuccess(response: ArticleResponse?) {
                    getView()?.onSystemArticles(page, response?.datas)
                }
            })
    }
}