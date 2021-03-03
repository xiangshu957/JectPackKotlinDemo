package com.rokin.wms.jectpackkotlin.utils

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.text.TextUtils
import android.util.Log
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * @Author: admin
 * Date: 2020/12/22
 * DES:
 */
object RomUtil {
    private const val TAG = "Rom"
    const val ROM_MIUI = "MIUI"
    const val ROM_EMUI = "EMUI"
    const val ROM_FLYME = "FLYME"
    const val ROM_OPPO = "OPPO"
    const val ROM_SMARTISAN = "SMARTISAN"
    const val ROM_VIVO = "VIVO"
    const val ROM_QIKU = "QIKU"
    private const val KEY_VERSION_MIUI = "ro.miui.ui.version.name"
    private const val KEY_VERSION_EMUI = "ro.build.version.emui"
    private const val KEY_VERSION_OPPO = "ro.build.version.opporom"
    private const val KEY_VERSION_SMARTISAN = "ro.smartisan.version"
    private const val KEY_VERSION_VIVO = "ro.vivo.os.version"
    private var sName: String? = null
    private var sVersion: String? = null

    //华为
    val isEmui: Boolean
        get() = check(ROM_EMUI)

    //小米
    val isMiui: Boolean
        get() = check(ROM_MIUI)

    //vivo
    val isVivo: Boolean
        get() = check(ROM_VIVO)

    //oppo
    val isOppo: Boolean
        get() = check(ROM_OPPO)

    //魅族
    val isFlyme: Boolean
        get() = check(ROM_FLYME)

    //360手机
    fun is360(): Boolean {
        return check(ROM_QIKU) || check("360")
    }

    //锤子
    val isSmartisan: Boolean
        get() = check(ROM_SMARTISAN)

    val name: String?
        get() {
            if (sName == null) {
                check("")
            }
            return sName
        }

    val version: String?
        get() {
            if (sVersion == null) {
                check("")
            }
            return sVersion
        }

    val baond: String
        get() = Build.BRAND

    fun check(rom: String): Boolean {
        if (sName != null) {
            return sName == rom
        }
        if (!TextUtils.isEmpty(
                getProp(KEY_VERSION_MIUI).also { sVersion = it }
            )
        ) {
            sName = ROM_MIUI
        } else if (!TextUtils.isEmpty(
                getProp(KEY_VERSION_EMUI).also { sVersion = it }
            )
        ) {
            sName = ROM_EMUI
        } else if (!TextUtils.isEmpty(
                getProp(KEY_VERSION_OPPO).also { sVersion = it }
            )
        ) {
            sName = ROM_OPPO
        } else if (!TextUtils.isEmpty(
                getProp(KEY_VERSION_VIVO).also { sVersion = it }
            )
        ) {
            sName = ROM_VIVO
        } else if (!TextUtils.isEmpty(
                getProp(KEY_VERSION_SMARTISAN).also { sVersion = it }
            )
        ) {
            sName = ROM_SMARTISAN
        } else {
            sVersion = Build.DISPLAY
            if (sVersion!!.toUpperCase().contains(ROM_FLYME)) {
                sName = ROM_FLYME
            } else {
                sVersion = Build.UNKNOWN
                sName = Build.MANUFACTURER.toUpperCase()
            }
        }
        return sName == rom
    }

    fun getProp(name: String): String? {
        var line: String?
        var input: BufferedReader? = null
        try {
            val p = Runtime.getRuntime().exec("getprop $name")
            input = BufferedReader(InputStreamReader(p.inputStream), 1024)
            line = input.readLine()
            input.close()
        } catch (ex: IOException) {
            Log.e(TAG, "Unable to read prop $name", ex)
            return null
        } finally {
            if (input != null) {
                try {
                    input.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        return line
    }

    /**
     * 获取app的versionName
     * @param context
     * @return
     */
    fun getVersionName(context: Context): String? {
        var versionName: String? = null
        try {
            val packageManager = context.packageManager
            val packageInfo =
                packageManager.getPackageInfo(context.packageName, 0)
            versionName = packageInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
        }
        return versionName
    }

    /**
     * 获取app的versionCode
     * @param context
     * @return
     */
    fun getVersionCode(context: Context): Int {
        var versionCode = 0
        try {
            val packageManager = context.packageManager
            val packageInfo =
                packageManager.getPackageInfo(context.packageName, 0)
            versionCode = packageInfo.versionCode
        } catch (e: PackageManager.NameNotFoundException) {
        }
        return versionCode
    }
}