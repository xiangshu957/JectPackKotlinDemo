package com.rokin.wms.jectpackkotlin.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import com.rokin.wms.jectpackkotlin.application.PdaApplication
import com.rokin.wms.jectpackkotlin.base.BaseViewModel
import com.rokin.wms.jectpackkotlin.constants.Constant
import com.rokin.wms.jectpackkotlin.mvvm.model.AddressModel
import com.rokin.wms.jectpackkotlin.utils.SpUtil
import com.rokin.wms.jectpackkotlin.utils.VerifyUtils

/**
 * @Author: ZhangRuixiang
 * Date: 2021/1/19
 * DES:
 */
class LoginViewModel : BaseViewModel() {

    var isHide: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    var username: MutableLiveData<String> = MutableLiveData<String>()


    var password: MutableLiveData<String> = MutableLiveData<String>()


   var addressModel: MutableLiveData<AddressModel> = MutableLiveData<AddressModel>()


    fun getUserInfo() {

        PdaApplication.getInstance()!!.applicationContext

        SpUtil.init(Constant.SP_NAME)
        val contains =
            SpUtil.contains(
                PdaApplication.getInstance()!!.applicationContext,
                Constant.USERNAME
            ) && SpUtil.contains(
                PdaApplication.getInstance()!!.applicationContext,
                Constant.PASSWORD
            )
        var username: String? = null
        var password: String? = null
        if (contains) {
            username =
                SpUtil[PdaApplication.getInstance()!!.applicationContext, Constant.USERNAME, ""] as String?
            password =
                SpUtil[PdaApplication.getInstance()!!.applicationContext, Constant.PASSWORD, ""] as String?
        }
        if (!VerifyUtils.isEmpty(username.toString())) {
            this.username.postValue(username.toString())
        }
        if (!VerifyUtils.isEmpty(password.toString())) {
            this.password.postValue(password.toString())
        }

    }

}