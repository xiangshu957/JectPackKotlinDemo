package com.rokin.wms.jectpackkotlin.utils

import android.util.Log

/**
 * @Author: ZhangRuixiang
 * Date: 2020/12/22
 * DES:
 */
object LogUtil {
    private const val TAG = "WMS_PDA"
    fun e(msg: String?) {
        Log.e(TAG, msg!!)
    }

    fun d(msg: String?) {
        Log.d(TAG, msg!!)
    }

    fun i(msg: String?) {
        Log.i(TAG, msg!!)
    }

    fun v(msg: String?) {
        Log.v(TAG, msg!!)
    }

    fun w(msg: String?) {
        Log.w(TAG, msg!!)
    }

    fun wtf(msg: String?) {
        Log.wtf(TAG, msg)
    }
}