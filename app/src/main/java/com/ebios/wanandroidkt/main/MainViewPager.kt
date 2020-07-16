package com.ebios.wanandroidkt.main

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs

class MainViewPager: ViewPager{

    private var downX=0f
    private var downY=0f

    constructor(context:Context):super(context)
    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet)

    //内部拦截 解决viewpage 与 RecyclerView 滑动冲突
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        super.onInterceptTouchEvent(ev)

        when(ev.action){
            MotionEvent.ACTION_DOWN ->{
                downX=ev.x
                downY=ev.y
                return  false
            }
            MotionEvent.ACTION_MOVE ,MotionEvent.ACTION_UP->{
               if (abs(ev.x-downX)> abs(ev.y- downY)){
                   return true
               }
            }
        }

        return super.onInterceptTouchEvent(ev)
    }


}