package com.ebios.wanandroidkt.api

import com.ebios.wanandroidkt.base.BaseResponse
import com.ebios.wanandroidkt.home.bean.Article
import com.ebios.wanandroidkt.home.bean.ArticleResponse
import com.ebios.wanandroidkt.home.bean.Banner
import com.ebios.wanandroidkt.project.bean.ProjectResponse
import com.ebios.wanandroidkt.project.bean.ProjectTab
import com.ebios.wanandroidkt.system.bean.SystemCategory
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    @GET("banner/json")
    fun getBanner(): Observable<BaseResponse<List<Banner>>>

    @GET("article/top/json")
    fun getTopArticle(): Observable<BaseResponse<List<Article>>>

    @GET("article/list/{page}/json")
    fun getArticles(@Path("page") page: Int): Observable<BaseResponse<ArticleResponse>>

    @GET("project/tree/json")
    fun getProjectTabs(): Observable<BaseResponse<List<ProjectTab>>>

    @GET("project/list/{page}/json")
    fun getProjectLists(@Path("page") page: Int, @Query("cid") cid: Int): Observable<BaseResponse<ProjectResponse>>

    @GET("tree/json")
    fun getSystem(): Observable<BaseResponse<List<SystemCategory>>>
    @GET("article/list/{page}/json")
    fun getSystemArticles(@Path("page") page: Int, @Query("cid") cid: Int): Observable<BaseResponse<ArticleResponse>>

}