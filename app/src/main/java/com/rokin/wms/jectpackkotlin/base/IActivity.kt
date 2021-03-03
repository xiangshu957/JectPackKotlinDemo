package com.rokin.wms.jectpackkotlin.base

/**
 * @Author: ZhangRuixiang
 * Date: 2021/1/26
 * DES:
 */
interface IActivity {

    fun bindLayout():Int

    fun viewModelId():Int

    fun initView()

    fun inject()

    fun initData()

    fun showToast(msg: String)

    fun showDialog(msg: String)

    fun hideDialog()

    fun register()

    fun scanHandler(msg: String)

    fun unBind()
}