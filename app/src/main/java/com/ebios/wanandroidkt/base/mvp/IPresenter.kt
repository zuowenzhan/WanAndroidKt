package com.ebios.wanandroidkt.base.mvp

interface IPresenter<V : IView> {

    fun attachView(view: V)

    fun detachView()

    fun isViewAttached(): Boolean

    fun getView(): V?
}