package com.ebios.wanandroidkt.gank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ebios.wanandroidkt.R
import com.ebios.wanandroidkt.project.ProjectFragment

class GankFragment: Fragment() {

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_gank, container, false)
        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance() = GankFragment()
    }
}