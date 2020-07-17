package com.ebios.wanandroidkt.web

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import androidx.appcompat.widget.Toolbar
import com.ebios.wanandroidkt.R
import com.ebios.wanandroidkt.base.BaseActivity
import com.ebios.wanandroidkt.utils.*
import com.ebios.wanandroidkt.view.XWebView

class WebViewActivity:BaseActivity() {

    private lateinit var toolbar: Toolbar
    private var webView: XWebView? = null
    private var moreMenuItem: MenuItem? = null
    private var title: String? = null
    private var link: String? = null
    private var id: Int? = -1
    private var author: String? = null
    private var loadUrl: String? = null
    private var favoriteSuccessView: View? = null

    companion object {
        val URL: String = "url"
    }

    override fun initView() {
        toolbar = findViewById(R.id.tb_web)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationIcon(R.drawable.ic_back)
        supportActionBar?.elevation = dp2px(mContext, 5f)
        toolbar.setNavigationOnClickListener {
            goBack()
        }
        webView = findViewById(R.id.pwv_webview)
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_web_view
    }

    override fun initData() {
        super.initData()

        val bundle: Bundle? = intent.extras
        loadUrl = bundle?.getString(URL)
        id = bundle?.getInt(ID)
        link = bundle?.getString(LINK)
        title = bundle?.getString(TITLE)
        author = bundle?.getString(AUTHOR)
        loadUrl?.let { webView?.loadUrl(it) }

        webView?.setWebViewCallback(object : XWebView.OnWebViewCallback {
            override fun onPageFinished(view: WebView?, url: String?) {
            }

            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                Log.e("debug", "progres = $newProgress")
            }

            override fun onReceivedTitle(view: WebView?, title: String?) {
                toolbar.title = title
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            }

            override fun onLoadResource(view: WebView, url: String) {
            }

            override fun onReceivedError(view: WebView, errorCode: Int, description: String, failingUrl: String) {
            }

            override fun onPageLoadComplete() {
                moreMenuItem?.isVisible = true
            }
        })


    }


    /**
     * 返回
     */
    private fun goBack() {
        val canGoBack = webView?.canGoBack() ?: false
        if (canGoBack) {
            webView?.goBack()
        } else {
            finish()
        }
    }

}