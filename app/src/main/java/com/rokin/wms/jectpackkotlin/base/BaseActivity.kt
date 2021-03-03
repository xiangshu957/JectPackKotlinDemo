package com.rokin.wms.jectpackkotlin.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.gyf.immersionbar.ImmersionBar
import com.rokin.wms.jectpackkotlin.utils.ToastUtil
import java.lang.reflect.ParameterizedType

/**
 * @Author: ZhangRuixiang
 * Date: 2021/1/26
 * DES:
 */
abstract class BaseActivity<D : ViewDataBinding, V : BaseViewModel> : AppCompatActivity(),
    IActivity {

    var immersionBar: ImmersionBar? = null

    protected var binding: D? = null
    private var viewModel: V? = null

    protected var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindLayout())

        immersionBar = ImmersionBar.with(this)
        immersionBar!!.transparentStatusBar().init()

        context = this

        bindViewModel()
        initView()
        inject()
        initData()
    }

    private fun bindViewModel() {

        binding = DataBindingUtil.setContentView(this, bindLayout())
        val modelClass: Class<V>
        val type = javaClass.genericSuperclass

        modelClass = if (type is ParameterizedType) {
            type.actualTypeArguments[1] as Class<V>
        } else {
            //如果没有指定泛型参数，则默认使用BaseViewModel
            BaseViewModel::class.java as Class<V>
        }
        viewModel = ViewModelProvider(this).get(modelClass)
        binding!!.setVariable(viewModelId(), viewModel)
    }

    override fun showDialog(msg: String) {

    }

    override fun hideDialog() {

    }

    override fun showToast(msg: String) {
        ToastUtil.instance!!.showToast(context, null, msg)
    }

    override fun register() {

    }

    override fun scanHandler(msg: String) {

    }

    override fun unBind() {

    }
}