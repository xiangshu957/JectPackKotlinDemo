package com.rokin.wms.jectpackkotlin.common.binding

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.inputmethod.EditorInfo
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Switch
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.rokin.wms.jectpackkotlin.constants.Constant
import com.rokin.wms.jectpackkotlin.constants.Constant.SP_NAME
import com.rokin.wms.jectpackkotlin.mvvm.model.AddressModel
import com.rokin.wms.jectpackkotlin.utils.SpUtil

/**
 * @Author: ZhangRuixiang
 * Date: 2021/1/19
 * DES:
 */
object DataBindingHelper {

    @BindingAdapter("switch")
    @JvmStatic
    fun isSwitch(switch: Switch, isHide: MutableLiveData<Boolean>) {

        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            isHide.postValue(isChecked)
        }

    }

    @BindingAdapter("showPwd")
    @JvmStatic
    fun showPassword(editText: EditText, isHide: Boolean) {
        if (EditorInfo.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD == editText.inputType && !isHide) {
            //如果不可见就设置为可见
            editText.inputType = EditorInfo.TYPE_TEXT_VARIATION_PASSWORD
            editText.transformationMethod = PasswordTransformationMethod.getInstance()
        } else {
            //如果可见就设置为不可见
            editText.inputType = EditorInfo.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            editText.transformationMethod = HideReturnsTransformationMethod.getInstance()
        }
        //执行上面的代码后光标会处于输入框的最前方,所以把光标位置挪到文字的最后面
        //执行上面的代码后光标会处于输入框的最前方,所以把光标位置挪到文字的最后面
        editText.setSelection(editText.text.toString().length)
    }

    @BindingAdapter("isChecked")
    @JvmStatic
    fun isChecked(checkBox: CheckBox, addressModel: AddressModel) {

        if (addressModel.isSelect) {
            checkBox.isChecked = addressModel.isSelect
            SpUtil.init(SP_NAME)
            SpUtil.put(checkBox.context, addressModel.type, addressModel.address)
            SpUtil.put(checkBox.context, Constant.LAST_SELECT, addressModel.type)
        } else {
            checkBox.isChecked = addressModel.isSelect
        }

    }

}