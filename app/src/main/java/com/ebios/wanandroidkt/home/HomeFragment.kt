package com.ebios.wanandroidkt.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ebios.wanandroidkt.R

import com.ebios.wanandroidkt.base.mvp.BaseMVPFragment
import com.ebios.wanandroidkt.home.bean.Article
import com.ebios.wanandroidkt.utils.*

import com.ebios.wanandroidkt.web.WebViewActivity
import com.ebios.wanandroidkt.web.WebViewActivity.Companion.URL
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import com.youth.banner.Banner
import com.youth.banner.listener.OnBannerListener
import com.youth.banner.loader.ImageLoader

class HomeFragment : BaseMVPFragment<HomeContract.View, HomePresenter>(), HomeContract.View {


    private lateinit var adapter: HomeRecyclerAdapter
    private lateinit var banner: Banner
    private var recyclerView: RecyclerView? = null
    private var refreshLayout: SmartRefreshLayout? = null
    private lateinit var headerView: View
    private var mCurPage: Int = 0
    private var dataList: List<Article> = ArrayList()

 override fun createPresenter(): HomePresenter {
     return HomePresenter()
 }

    override fun initView(rootView: View?, savedInstanceState: Bundle?) {

        refreshLayout = rootView?.findViewById(R.id.srl_home)
        refreshLayout?.setEnableRefresh(true)
        recyclerView = rootView?.findViewById(R.id.rv_home)

        headerView = layoutInflater.inflate(R.layout.layout_home_header, null, false)
        banner = headerView.findViewById(R.id.banner)
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_home
    }

    override fun initData() {
        super.initData()
        //设置分割线
        val itemDecoration = LinearItemDecoration(mContext).color(ContextCompat.getColor(mContext, R.color.white_eaeaea))
            .height(1f)
            .margin(15f, 15f)
            .jumpPositions(arrayOf(0))
        recyclerView?.addItemDecoration(itemDecoration)
        recyclerView?.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
        adapter = HomeRecyclerAdapter(R.layout.item_home_recycler)

        adapter.addHeaderView(headerView)

        adapter.onItemClickListener= BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            val bundle = Bundle()
            val bean = dataList[position]
            bundle.putString(URL, bean.link)
            bundle.putInt(ID, bean.id)
            bundle.putString(AUTHOR, bean.author)
            bundle.putString(LINK, bean.link)
            bundle.putString(TITLE, bean.title)
            gotoActivity(
                activity!!,
                WebViewActivity().javaClass,
                bundle
            )
        }
        recyclerView?.adapter = adapter
        // 获取 banner
        presenter.getBanner()
        // 获取文章
        presenter.getArticles(mCurPage)

        setListener()
    }

    private fun setListener() {

        refreshLayout?.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
            override fun onLoadMore(refreshLayout: RefreshLayout) {
                presenter.getArticles(mCurPage)

            }

            override fun onRefresh(refreshLayout: RefreshLayout) {
                presenter.getArticles(0)
            }
        })

    }


    override fun onBanner(list: List<com.ebios.wanandroidkt.home.bean.Banner>?) {
        //轮播图地址
        val urlList = mutableListOf<String>()
        if (list != null) {
            for (banner in list) {
                urlList.add(banner.imagePath)
            }
        }
        //设置图片加载器
        banner.setImageLoader(object : ImageLoader() {
            override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
                val roundedCorners = RoundedCorners(20)
                val bitmapTransform = RequestOptions.bitmapTransform(roundedCorners)
                Glide.with(context!!).load(path).apply(bitmapTransform).into(imageView!!)
            }
        })
        banner.setImages(urlList)
            .isAutoPlay(true)
            .start()

        banner.setOnBannerListener(object : OnBannerListener {
            override fun OnBannerClick(position: Int) {

                if (list != null) {
                    val bundle = Bundle()
                    val banner = list[position]
                    bundle.putString(URL, banner.url)
                    bundle.putInt(ID, banner.id)
                    gotoActivity(
                        activity!!,
                        WebViewActivity().javaClass,
                        bundle
                    )
                }

            }
        })


    }

    override fun onArticles(page: Int, list: List<Article>?) {
        refreshLayout?.finishRefresh()
        refreshLayout?.finishLoadMore()
        mCurPage = page + 1
        if (list != null) {
            dataList = list
        }
        adapter.setNewData(dataList)
    }

    override fun showLoading() {

    }

    override fun dismissLoading() {

    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}