package com.rokin.wms.jectpackkotlin.utils

import android.content.Context
import android.os.Environment
import java.io.File

/**
 * @Author: ZhangRuixiang
 * Date: 2020/12/27
 * DES:
 */
object FileUtil {
    /**
     * 存储在sd卡上目录名字(默认)
     */
    var sdCardCacheDirName = "niucooCache"

    /**
     * SD卡路径
     *
     * @return
     */
    fun getSavePath(context: Context): String {
        var sdDir: File? = null
        val sdExist =
            Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
        sdDir = if (sdExist) {
            Environment.getExternalStorageDirectory()
        } else {
            context.filesDir
        }
        return sdDir.absolutePath + File.separator
    }

    fun createFileName(appName: String): String {
        val currentTimeMillis = System.currentTimeMillis()
        return appName + "_" + currentTimeMillis
    }

    fun deleteFile(file: File): Boolean {
        if (file.isFile) {
            file.delete()
            return true
        }
        if (file.isDirectory) {
            val childFiles = file.listFiles()
            if (childFiles == null || childFiles.size == 0) {
                file.delete()
                return true
            }
            for (i in childFiles.indices) {
                deleteFile(childFiles[i])
            }
            file.delete()
        }
        return if (file.exists()) {
            false
        } else {
            true
        }
    }
}