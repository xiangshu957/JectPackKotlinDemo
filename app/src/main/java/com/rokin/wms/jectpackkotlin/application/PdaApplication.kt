package com.rokin.wms.jectpackkotlin.application

import android.app.Application
import android.content.Context
import android.os.Build
import com.alibaba.android.arouter.launcher.ARouter
import com.rokin.wms.jectpackkotlin.constants.Constant
import com.rokin.wms.jectpackkotlin.utils.SpUtil
import com.uuzuche.lib_zxing.activity.ZXingLibrary
import java.util.*

/**
 * @Author: admin
 * Date: 2020/12/21
 * DES:
 */
class PdaApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        instance = this
        init()
        saveData()
        initJPush()
        println(Build.MODEL)
    }

    companion object {
        private var instance: PdaApplication? = null
        fun getInstance(): PdaApplication? {
            return instance
        }
    }

    private fun init() {
        ARouter.openLog() // 打印日志
        ARouter.openDebug() // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this@PdaApplication)
        ZXingLibrary.initDisplayOpinion(applicationContext)
    }

    private fun saveData() {
        SpUtil.init(Constant.SP_NAME)
        SpUtil.put(applicationContext!!, Constant.RELEASE, Constant.RELEASE_ADDRESS)
        SpUtil.put(applicationContext!!, Constant.TEST, Constant.TEST_ADDRESS)
        SpUtil.put(applicationContext!!, Constant.UAT, Constant.UAT_ADDRESS)
        if (!SpUtil.contains(applicationContext!!, Constant.LAST_SELECT)) {
            SpUtil.put(applicationContext!!, Constant.LAST_SELECT, Constant.RELEASE)
        } else {
            when (Objects.requireNonNull(
                SpUtil[applicationContext!!, Constant.LAST_SELECT, Constant.RELEASE]
            ) as String?) {
                Constant.TEST_ADDRESS -> Constant.address = Constant.TEST_ADDRESS
                Constant.UAT -> Constant.address = Constant.UAT_ADDRESS
                Constant.CUSTOM -> Constant.address = Constant.CUSTOM_ADDRESS
                Constant.RELEASE -> Constant.address = Constant.RELEASE_ADDRESS
                else -> Constant.address = Constant.RELEASE_ADDRESS
            }
        }
    }

    private fun initJPush() {
        /*JPushInterface.setDebugMode(true)
        JPushInterface.init(this)*/
    }

}