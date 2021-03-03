package com.rokin.wms.jectpackkotlin.utils

import android.content.Context
import android.net.ConnectivityManager
import com.rokin.wms.jectpackkotlin.application.PdaApplication

/**
 * @Author: ZhangRuixiang
 * Date: 2021/1/14
 * DES:
 */
object NetUtil {
    val isNetConnect: Boolean
        get() {
            val connectivityManager = PdaApplication().applicationContext
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = connectivityManager.activeNetworkInfo
            return info != null && info.isConnected
        }
}