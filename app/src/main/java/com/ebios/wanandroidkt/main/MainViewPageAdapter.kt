package com.ebios.wanandroidkt.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.ebios.wanandroidkt.R
import com.ebios.wanandroidkt.common.FragmentItem

class MainViewPageAdapter(var context: Context,var fm: FragmentManager,var titleList:List<String>,var fragmentItems:  List<Fragment> ) : FragmentPagerAdapter(fm){

    private var layoutInflater: LayoutInflater = LayoutInflater.from(context)


    override fun getItem(position: Int): Fragment {

        return fragmentItems[position]
    }

    override fun getCount(): Int {

        return fragmentItems.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }


    fun getTabView(position: Int): View {
        val view: View = layoutInflater.inflate(R.layout.layout_main_tab, null, false)
        val textView: TextView = view.findViewById(R.id.tv_tab_title)
        textView.text = getPageTitle(position)
        textView.setTextColor(context.resources.getColor(R.color.color_666))
        textView.textSize = 18f
        return view
    }

}