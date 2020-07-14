package com.ebios.wanandroidkt.base

import android.app.Application
import android.content.Context
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor

class MyApplication: Application() {

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