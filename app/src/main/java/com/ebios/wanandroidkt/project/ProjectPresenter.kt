package com.ebios.wanandroidkt.project

import com.ebios.wanandroidkt.api.ApiService
import com.ebios.wanandroidkt.base.mvp.BasePresenter
import com.ebios.wanandroidkt.net.BaseObserver
import com.ebios.wanandroidkt.project.bean.ProjectTab

class ProjectPresenter:BasePresenter<ProjectContract.View>(), ProjectContract.Presenter{

    override fun getProjectTabs() {

        addSubscribe(create(ApiService::class.java).getProjectTabs(),object :BaseObserver<List<ProjectTab>>(){
            override fun onSuccess(data: List<ProjectTab>?) {

                if (this@ProjectPresenter.isViewAttached()){
                    this@ProjectPresenter.getView()?.onProjectTabs(data)
                }

            }
        })

    }
}