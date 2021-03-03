package com.rokin.wms.jectpackkotlin.mvvm.view

import android.annotation.SuppressLint
import android.graphics.Color
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.CompoundButton
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu
import com.rokin.wms.jectpackkotlin.BR
import com.rokin.wms.jectpackkotlin.R
import com.rokin.wms.jectpackkotlin.base.BaseActivity
import com.rokin.wms.jectpackkotlin.constants.Constant
import com.rokin.wms.jectpackkotlin.databinding.ActivityLoginBinding
import com.rokin.wms.jectpackkotlin.databinding.LayoutSlideBinding
import com.rokin.wms.jectpackkotlin.interfaces.HeadCallback
import com.rokin.wms.jectpackkotlin.mvvm.viewmodel.LoginViewModel
import com.rokin.wms.jectpackkotlin.utils.SpUtil
import com.rokin.wms.jectpackkotlin.utils.VerifyUtils

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

    var slidingMenu: SlidingMenu? = null

    override fun bindLayout(): Int {
        return R.layout.activity_login
    }

    override fun viewModelId(): Int {
        return BR.loginViewModel
    }

    override fun initView() {

        //如果可见就设置为不可见
        binding!!.etLoginPassword.inputType = EditorInfo.TYPE_TEXT_VARIATION_PASSWORD
        binding!!.etLoginPassword.transformationMethod =
            PasswordTransformationMethod.getInstance()
        //执行上面的代码后光标会处于输入框的最前方,所以把光标位置挪到文字的最后面
        //执行上面的代码后光标会处于输入框的最前方,所以把光标位置挪到文字的最后面
        binding!!.etLoginPassword.setSelection(binding!!.etLoginPassword.text.toString().length)
        binding!!.headLogin.setDataImg(
            R.color.theme_color,
            "仓储系统PDA",
            false,
            0,
            true,
            R.drawable.ic_set,
            false,
            "",
            onHeadCallBack
        )
    }

    private val onHeadCallBack = object : HeadCallback {
        override fun onLeftBtnClickListener() {

        }

        @SuppressLint("InflateParams")
        override fun onRightBtnClickListener() {
            slidingMenu = SlidingMenu(context!!)
            val inflate = layoutInflater.inflate(R.layout.layout_slide, null)
            slidingMenu!!.menu = inflate
            slidingMenu!!.mode = SlidingMenu.RIGHT
            slidingMenu!!.touchModeAbove = SlidingMenu.TOUCHMODE_MARGIN
            slidingMenu!!.setFadeDegree(0.55f)
            slidingMenu!!.setBackgroundColor(Color.WHITE)
            slidingMenu!!.behindScrollScale = 1.0f
            slidingMenu!!.attachToActivity(this@LoginActivity, SlidingMenu.SLIDING_CONTENT)

            initSlidingMenu()
            slidingMenu!!.showMenu()


        }

    }

    private var slideBinding:LayoutSlideBinding?=null
    private fun initSlidingMenu() {

        slideBinding = DataBindingUtil.setContentView(this,R.layout.layout_slide)

    }

    override fun inject() {

    }

    override fun initData() {

        binding!!.swPwdShow.setOnCheckedChangeListener(onCheckedChangeListener)
        binding!!.loginViewModel!!.isHide.observe(this, observer)
        binding!!.onLoginBtnClickHandlerEvent = onLoginBtnClickHandlerEvent
        binding!!.loginViewModel!!.username.observe(this, usernameObserve)
        binding!!.loginViewModel!!.password.observe(this, passwordObserve)
        binding!!.loginViewModel!!.getUserInfo()
        binding!!.etLoginUsername.setSelection(binding!!.etLoginUsername.text.toString().length)
        binding!!.etLoginPassword.setSelection(binding!!.etLoginPassword.text.toString().length)
    }

    private var onLoginBtnClickHandlerEvent = View.OnClickListener {
        showToast("登录")

        val username = binding!!.etLoginUsername.text.toString()
        val password = binding!!.etLoginPassword.text.toString()

        SpUtil.init(Constant.SP_NAME)

        if (!VerifyUtils.isEmpty(username)) {
            SpUtil.put(context!!, Constant.USERNAME, username)
        }
        if (!VerifyUtils.isEmpty(password)) {
            SpUtil.put(context!!, Constant.PASSWORD, password)
        }

    }

    private var usernameObserve = Observer<String> {

        binding!!.userName = it
        binding!!.etLoginUsername.setSelection(binding!!.etLoginUsername.text.toString().length)

    }

    private var passwordObserve = Observer<String> {

        binding!!.password = it
        binding!!.etLoginPassword.setSelection(binding!!.etLoginPassword.text.toString().length)

    }

    private var observer = Observer<Boolean> { t ->
        if (EditorInfo.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD == binding!!.etLoginPassword.inputType && !t!!) {
            //如果不可见就设置为可见
            binding!!.etLoginPassword.inputType = EditorInfo.TYPE_TEXT_VARIATION_PASSWORD
            binding!!.etLoginPassword.transformationMethod =
                PasswordTransformationMethod.getInstance()
        } else {
            //如果可见就设置为不可见
            binding!!.etLoginPassword.inputType =
                EditorInfo.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            binding!!.etLoginPassword.transformationMethod =
                HideReturnsTransformationMethod.getInstance()
        }
        //执行上面的代码后光标会处于输入框的最前方,所以把光标位置挪到文字的最后面
        //执行上面的代码后光标会处于输入框的最前方,所以把光标位置挪到文字的最后面
        binding!!.etLoginPassword.setSelection(binding!!.etLoginPassword.text.toString().length)
    }

    private var onCheckedChangeListener =
        CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            binding!!.loginViewModel!!.isHide.postValue(
                isChecked
            )
        }


}