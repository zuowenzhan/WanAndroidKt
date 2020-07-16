package com.ebios.wanandroidkt.system

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ebios.wanandroidkt.R
import com.ebios.wanandroidkt.project.ProjectFragment

class SystemFragment:Fragment() {
    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_system, container, false)
        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance() = SystemFragment()
    }
}