package com.ebios.wanandroidkt.base

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ebios.wanandroidkt.R
import com.jaeger.library.StatusBarUtil

abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var mContext: Context

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        mContext = this

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR//黑色
        }
        StatusBarUtil.setColor(this, resources.getColor(R.color.color_f5c), 0)
//        if (isEventBusAnnotationPresent()) {
//            EventBusUtils.register(this)
//        }

        initView()
        initData()
    }


    //open 的方法可以被继承、重写
    open fun initData() {
    }

    abstract fun initView()

    abstract fun getLayoutResId(): Int

//    private fun isEventBusAnnotationPresent(): Boolean {
//        return javaClass.isAnnotationPresent(EventBusSubscribe::class.java)
//    }

    override fun onDestroy() {
        super.onDestroy()

    }


}