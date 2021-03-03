package com.rokin.wms.jectpackkotlin.utils

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.rokin.wms.jectpackkotlin.R
import java.util.*

/**
 * @Author: ZhangRuixiang
 * Date: 2020/12/22
 * DES:
 */
class ToastUtil private constructor() {
    private var toast: Toast? = null

    /**
     * @param context 上下文
     * @param root    父布局
     * @param msg     内容
     */
    fun showToast(
        context: Context?,
        root: ViewGroup?,
        msg: String?
    ) {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.layout_toast, root)
        val tvToast = view.findViewById<View>(R.id.tv_toast) as TextView
        tvToast.text = msg
        tvToast.setTextColor(Color.WHITE)
        toast = Toast(context)
        toast!!.setGravity(Gravity.CENTER, 0, 0)
        toast!!.view = view
        toast!!.show()
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                toast!!.show()
            }
        }, 0, 3000) //Toast  long默认显示的是3000毫秒，所以设置成3000
        Timer().schedule(object : TimerTask() {
            override fun run() {
                toast!!.cancel()
                timer.cancel()
            }
        }, 1000)
    }

    companion object {
        private var toastUtil: ToastUtil? = null
        val instance: ToastUtil?
            get() {
                if (toastUtil == null) {
                    synchronized(ToastUtil::class.java) {
                        if (toastUtil == null) {
                            toastUtil = ToastUtil()
                        }
                    }
                }
                return toastUtil
            }
    }
}