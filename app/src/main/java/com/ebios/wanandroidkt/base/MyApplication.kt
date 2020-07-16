package com.ebios.wanandroidkt.base

import android.app.Application
import android.content.Context
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor

class MyApplication: Application() {

//    git add .
//    git commit -m '本次提交描述'
//    git push

//    git commit -am  '本次提交描述'
//    git push

    //git commit -am '提交的信息' && git push

//git push -u origin master

    //获取cookie
    private lateinit var cookieJar: PersistentCookieJar
    //单例
    companion object {
        private lateinit var context: Context

        private lateinit var instance: MyApplication

        fun getContext(): Context {
            return context.applicationContext
        }

        fun getInstance(): MyApplication {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        instance = this
        cookieJar = PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(context))
    }

    fun getPersistentCookieJar(): PersistentCookieJar {
        return cookieJar
    }



}