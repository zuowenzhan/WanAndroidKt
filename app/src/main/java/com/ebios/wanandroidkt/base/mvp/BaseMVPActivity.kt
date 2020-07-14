package com.ebios.wanandroidkt.base.mvp

import com.ebios.wanandroidkt.base.BaseActivity


abstract class BaseMVPActivity<in V:IView,P :IPresenter<in V>> :BaseActivity(),IView{

   protected  lateinit var presenter:P
    override fun initData() {
        super.initData()
        presenter=createPresenter()
        presenter.attachView(this as V)
    }

    abstract fun createPresenter(): P


}