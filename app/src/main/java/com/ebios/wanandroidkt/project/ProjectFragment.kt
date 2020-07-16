package com.ebios.wanandroidkt.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ebios.wanandroidkt.R
import com.ebios.wanandroidkt.home.HomeFragment

class ProjectFragment:Fragment() {

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_project, container, false)
        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProjectFragment()
    }
}