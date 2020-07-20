package com.ebios.wanandroidkt.system

import com.ebios.wanandroidkt.api.ApiService
import com.ebios.wanandroidkt.base.mvp.BasePresenter
import com.ebios.wanandroidkt.net.BaseObserver
import com.ebios.wanandroidkt.system.bean.SystemCategory

class SystemPresenter : BasePresenter<SystemContract.View>(), SystemContract.Presenter {
    override fun getSystemCategory() {

        addSubscribe(create(ApiService::class.java).getSystem(), object : BaseObserver<List<SystemCategory>>() {
            override fun onSuccess(data: List<SystemCategory>?) {
                getView()?.onSystemCategory(data)
            }
        })

    }
}