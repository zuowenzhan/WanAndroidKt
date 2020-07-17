package com.ebios.wanandroidkt.project

import com.ebios.wanandroidkt.base.mvp.IView
import com.ebios.wanandroidkt.project.bean.ProjectTab

class ProjectContract {
    interface View:IView{
        fun  onProjectTabs(projectTabs: List<ProjectTab>?)
    }
    interface Presenter {
        fun getProjectTabs()
    }

}