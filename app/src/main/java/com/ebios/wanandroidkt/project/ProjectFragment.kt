package com.ebios.wanandroidkt.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import com.ebios.wanandroidkt.R
import com.ebios.wanandroidkt.base.mvp.BaseMVPFragment
import com.ebios.wanandroidkt.common.FragmentItem
import com.ebios.wanandroidkt.home.HomeFragment
import com.ebios.wanandroidkt.project.bean.ProjectTab
import com.ebios.wanandroidkt.project.page.ProjectPageFragment
import com.google.android.material.tabs.TabLayout

class ProjectFragment: BaseMVPFragment<ProjectContract.View, ProjectPresenter>(), ProjectContract.View  {


    private lateinit var adapter: ProjectPageAdapter

    companion object {
        @JvmStatic
        fun newInstance() = ProjectFragment()
    }
    override fun getLayoutResId(): Int =R.layout.fragment_project

    override fun createPresenter(): ProjectPresenter {
       return ProjectPresenter()
    }

    override fun initView(rootView: View?, savedInstanceState: Bundle?) {

        var tabLayout: TabLayout? = rootView?.findViewById(R.id.tl_project_tabs)
        var viewPager:ProjectViewPager?= rootView?.findViewById(R.id.vp_project_pager)
        val fragmentList= mutableListOf<FragmentItem>()
        adapter= ProjectPageAdapter(childFragmentManager,fragmentList)
        viewPager?.adapter=adapter
        tabLayout?.setupWithViewPager(viewPager)

    }

    override fun initData() {
        super.initData()
        presenter.getProjectTabs()
    }


    override fun onProjectTabs(projectTabs: List<ProjectTab>?) {
        val projectTabsList = getFragmentItems(projectTabs)
        adapter.setDataSource(projectTabsList)
    }

    private fun getFragmentItems(projectTabs: List<ProjectTab>?): List<FragmentItem> {
        val list = mutableListOf<FragmentItem>()
        if (projectTabs != null) {
            for (projectTab in projectTabs) {
                list.add(
                    FragmentItem(
                        projectTab.name, ProjectPageFragment.newInstance(projectTab.id)
                    )
                )
            }
        }
        return list
    }

    override fun showLoading() {

    }

    override fun dismissLoading() {

    }
}