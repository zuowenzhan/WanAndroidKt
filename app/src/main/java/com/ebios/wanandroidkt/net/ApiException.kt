package com.ebios.wanandroidkt.net

data class ApiException(var errCode:Int,var errMsg: String):Exception()