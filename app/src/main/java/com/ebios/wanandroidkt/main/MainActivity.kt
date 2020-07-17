package com.ebios.wanandroidkt.main

import android.Manifest
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.ebios.wanandroidkt.R
import com.ebios.wanandroidkt.base.mvp.BaseMVPActivity
import com.ebios.wanandroidkt.gank.GankFragment
import com.ebios.wanandroidkt.home.HomeFragment
import com.ebios.wanandroidkt.project.ProjectFragment
import com.ebios.wanandroidkt.system.SystemFragment
import com.google.android.material.tabs.TabLayout
import com.yanzhenjie.permission.AndPermission
import kotlin.system.exitProcess

class MainActivity : BaseMVPActivity<MainContract.View, MainPresenter>(), MainContract.View {


    private lateinit var mainMenu: ImageView
    private lateinit var mainSearch: ImageView
    private lateinit var mainTabLayout: TabLayout
    private lateinit var mainViewPager: MainViewPager
    private lateinit var mAdapter: MainViewPageAdapter
    private lateinit var drawerLayout: DrawerLayout
    private var loggedIn = false

    override fun createPresenter(): MainPresenter {
       return MainPresenter();
    }

    override fun initView() {

        drawerLayout = findViewById(R.id.dl_drawer_layout)
        //StatusBarUtil.setColorForDrawerLayout(this, drawerLayout, resources.getColor(R.color.colorPrimary), 0)
        mainMenu = findViewById(R.id.iv_main_menu)
        mainSearch = findViewById(R.id.iv_main_search)
        mainTabLayout = findViewById(R.id.tl_main_tab)
        mainViewPager = findViewById(R.id.vp_main_pager)

    }

    override fun initData() {
        super.initData()
        val titleList = mutableListOf<String>()
        titleList.add("首页")
        titleList.add("项目")
        titleList.add("体系")
        titleList.add("干货")
        val fragmentList = mutableListOf<Fragment>()
        fragmentList.add(HomeFragment.newInstance())
        fragmentList.add(ProjectFragment.newInstance())
        fragmentList.add(SystemFragment.newInstance())
        fragmentList.add(GankFragment.newInstance())

        mAdapter = MainViewPageAdapter(this, supportFragmentManager, titleList,fragmentList)
        mainViewPager.adapter = mAdapter
        mainTabLayout.setupWithViewPager(mainViewPager)



        for (i in 0..mainTabLayout.tabCount) {
            val tabView: TabLayout.Tab? = mainTabLayout.getTabAt(i)
            tabView?.customView = mAdapter.getTabView(i)
        }
        // 默认选中第 0 个
        mainViewPager.currentItem = 0
        changeTabView(mainTabLayout.getTabAt(0), 18f, true)

        mainTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                changeTabView(tab, 16f, false)
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                changeTabView(tab, 18f, true)

            }
        })

        //获取权限  读取sd卡  读取地址  获取照相机  获取地理位置android.permission.
        AndPermission.with(this@MainActivity)
            .requestCode(101)
            .permission(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
                Manifest.permission.INTERNET,
                Manifest.permission.READ_PHONE_STATE
            ).send()


    }


    private fun changeTabView(tab: TabLayout.Tab?, textSize: Float, isSelected: Boolean) {
        val view: View? = tab?.customView
        val textView: TextView? = view?.findViewById(R.id.tv_tab_title)
        textView?.textSize = textSize
        if (isSelected) {
            textView?.setTextColor(resources.getColor(android.R.color.black))
            val width = textView?.measuredWidth
            Log.e("debug", "width = $width")
        } else {
            textView?.setTextColor(resources.getColor(R.color.gray_959698))
        }
    }
    override fun getLayoutResId(): Int =R.layout.activity_main

    private var lastTime: Long = 0L
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            val now = System.currentTimeMillis()
            if (now - lastTime > 1000) {
                Toast.makeText(mContext, "再按一次,推出应用", Toast.LENGTH_LONG).show()
                lastTime = now
                return false
            }
            finish()
            exitProcess(0)
        }
        return super.onKeyDown(keyCode, event)
    }
    override fun showLoading() {

    }

    override fun dismissLoading() {

    }


}
