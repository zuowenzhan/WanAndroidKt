package com.ebios.wanandroidkt.project.page

import android.util.Log
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.ebios.wanandroidkt.R
import com.ebios.wanandroidkt.project.bean.Project
import com.ebios.wanandroidkt.utils.createColorDrawable

class ProjectAdapter(layoutId: Int) : BaseQuickAdapter<Project, BaseViewHolder>(layoutId) {

    override fun convert(helper: BaseViewHolder?, item: Project?) {
        Log.e("debug", "concocncccc")
        helper?.setText(R.id.tv_project_title, item?.title)
            ?.setText(R.id.tv_project_author, item?.author)
            ?.setText(R.id.tv_project_time, item?.niceDate)
            ?.addOnClickListener(R.id.iv_project_image)    // 设置子 view 可以响应点击事件

        val colorDrawable = createColorDrawable(mContext)
        Glide.with(mContext)
            .load(item?.envelopePic)
            .placeholder(colorDrawable)
            .error(colorDrawable)
            .into(helper!!.getView(R.id.iv_project_image))
    }
}