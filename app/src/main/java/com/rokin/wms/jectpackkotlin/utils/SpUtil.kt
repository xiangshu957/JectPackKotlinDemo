package com.rokin.wms.jectpackkotlin.utils

import android.content.Context
import android.content.SharedPreferences.Editor
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/**
 * @Author: ZhangRuixiang
 * Date: 2020/12/24
 * DES:SharedPreferences 工具类
 */
object SpUtil {
    private var SP_NAME = "wms_pda"
    fun init() {}
    fun init(spName: String) {
        SP_NAME = spName
    }

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param context
     * @param key
     * @param object
     */
    fun put(
        context: Context,
        key: String?,
        `object`: Any
    ) {
        val sp =
            context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        val edit = sp.edit()
        if (`object` is String) {
            edit.putString(key, `object`)
        } else if (`object` is Int) {
            edit.putInt(key, `object`)
        } else if (`object` is Boolean) {
            edit.putBoolean(key, `object`)
        } else if (`object` is Float) {
            edit.putFloat(key, `object`)
        } else if (`object` is Long) {
            edit.putLong(key, `object`)
        } else {
            edit.putString(key, `object`.toString())
        }
        SharedPreferencesCompat.apply(edit)
    }

    operator fun get(
        context: Context,
        key: String?,
        defaultValue: Any?
    ): Any? {
        val sp =
            context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        if (defaultValue is String) {
            return sp.getString(key, defaultValue as String?)
        } else if (defaultValue is Int) {
            return sp.getInt(key, (defaultValue as Int?)!!)
        } else if (defaultValue is Boolean) {
            return sp.getBoolean(key, (defaultValue as Boolean?)!!)
        } else if (defaultValue is Float) {
            return sp.getFloat(key, (defaultValue as Float?)!!)
        } else if (defaultValue is Long) {
            return sp.getLong(key, (defaultValue as Long?)!!)
        }
        return null
    }

    /**
     * 移除某个值
     *
     * @param context
     * @param key
     */
    fun remove(context: Context, key: String?) {
        val sp =
            context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        val edit = sp.edit()
        edit.remove(key)
        SharedPreferencesCompat.apply(edit)
    }

    /**
     * 清除所有的值
     *
     * @param context
     */
    fun clear(context: Context) {
        val sp =
            context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        val edit = sp.edit()
        edit.clear()
        SharedPreferencesCompat.apply(edit)
    }

    /**
     * 查询某个key是否存在
     *
     * @param context
     * @param key
     * @return
     */
    fun contains(context: Context, key: String?): Boolean {
        val sp =
            context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        return sp.contains(key)
    }

    /**
     * 获取所有的键值对
     *
     * @param context
     * @return
     */
    fun getAll(context: Context): Map<String, *> {
        val sp =
            context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        return sp.all
    }

    /**
     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
     */
    private object SharedPreferencesCompat {
        private val sApplyMethod =
            findApplyMethod()

        /**
         * 反射查找apply的方法
         *
         * @return
         */
        private fun findApplyMethod(): Method? {
            try {
                val editorClass = Editor::class.java
                return editorClass.getMethod("apply")
            } catch (e: NoSuchMethodException) {
            }
            return null
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         *
         * @param editor
         */
        fun apply(editor: Editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(
                        editor
                    )
                    return
                }
            } catch (e: IllegalArgumentException) {
            } catch (e: IllegalAccessException) {
            } catch (e: InvocationTargetException) {
            }
            editor.commit()
        }
    }
}