package com.ebios.wanandroidkt.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ebios.wanandroidkt.R

class HomeFragment : Fragment() {


    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}