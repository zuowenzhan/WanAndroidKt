package com.ebios.wanandroidkt.base.mvp

import com.ebios.wanandroidkt.base.BaseFragment


abstract class BaseMVPFragment<in V : IView, P : IPresenter<in V>> : BaseFragment(), IView {

    protected lateinit var presenter: P

    override fun initData() {
        presenter = createPresenter()
        presenter.attachView(this as V)
    }

    abstract fun createPresenter(): P


}