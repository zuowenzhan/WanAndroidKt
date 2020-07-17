package com.ebios.wanandroidkt.project.page

import com.ebios.wanandroidkt.api.ApiService
import com.ebios.wanandroidkt.base.mvp.BasePresenter
import com.ebios.wanandroidkt.net.BaseObserver
import com.ebios.wanandroidkt.project.bean.ProjectResponse

class ProjectPagePresenter : BasePresenter<ProjectPageContract.View>(), ProjectPageContract.Presenter {
    override fun getProjectLists(page: Int, cid: Int) {

        addSubscribe(create(ApiService::class.java).getProjectLists(page,cid),object :BaseObserver<ProjectResponse>(){
            override fun onSuccess(data: ProjectResponse?) {

                if (this@ProjectPagePresenter.isViewAttached()) {
                    this@ProjectPagePresenter.getView()?.onProjectLists(page, data)
                }

            }

        })
    }
}