package com.ebios.wanandroidkt.project.page

import com.ebios.wanandroidkt.base.mvp.IView
import com.ebios.wanandroidkt.project.bean.ProjectResponse

interface ProjectPageContract {
    interface View : IView {
        fun onProjectLists(page: Int, response: ProjectResponse?)
    }

    interface Presenter {
        /**
         * 项目列表
         */
        fun getProjectLists(page: Int, cid: Int)

    }
}