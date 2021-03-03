package com.rokin.wms.jectpackkotlin.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * @Author: ZhangRuixiang
 * Date: 2020/12/24
 * DES: 验证工具类
 */
object VerifyUtils {
    /**
     * 验证字符串是否为空或者为null
     *
     * @param str
     * @return
     */
    fun isEmpty(str: String?): Boolean {
        return str == null || str.trim { it <= ' ' } == "" || str.length == 0 || str.trim { it <= ' ' } == "null"
    }

    fun getDateToString(time: Long): String {
        val d = Date(time)
        val sf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return sf.format(d)
    }

    fun getDateToStringMD(time: Long): String {
        val date = Date(time)
        val sf = SimpleDateFormat("MM月dd日 HH:mm")
        sf.timeZone = TimeZone.getTimeZone("GMT+08:00")
        return sf.format(date)
    }

    fun getDateToStringYMD(time: Long): String {
        val date = Date(time)
        val sf = SimpleDateFormat("yyyy-MM-dd")
        return sf.format(date)
    }
}