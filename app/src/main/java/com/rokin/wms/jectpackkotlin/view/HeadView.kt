package com.rokin.wms.jectpackkotlin.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.rokin.wms.jectpackkotlin.R
import com.rokin.wms.jectpackkotlin.interfaces.HeadCallback

/**
 * @Author: ZhangRuixiang
 * Date: 2020/12/23
 * DES:
 */
class HeadView : FrameLayout, View.OnClickListener {
    private var context = null
    private var view: View? = null
    private var headRlRight: RelativeLayout? = null
    private var headRl: RelativeLayout? = null
    private var headImgLeft: ImageView? = null
    private var headImgRight: ImageView? = null
    private var headTvTitle: TextView? = null
    var tvRight: TextView? = null
        private set
        get() {
            return field
        }
    private var headCallback: HeadCallback? = null

    constructor(context: Context) : super(context) {
        initView(context)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(context, attrs) {
        initView(context)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        initView(context)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        initView(context)
    }

    private fun initView(context: Context) {
        this.context != context
        view = LayoutInflater.from(context).inflate(R.layout.layout_headview, this)
        headRl = view!!.findViewById(R.id.head_rl)
        headImgLeft = view!!.findViewById(R.id.head_img_left)
        headImgRight = view!!.findViewById(R.id.head_img_right)
        headTvTitle = view!!.findViewById(R.id.head_tv_title)
        tvRight = view!!.findViewById(R.id.head_tv_right)
        headRlRight = view!!.findViewById(R.id.head_rl_right)
    }

    fun setData(
        @ColorRes colorId: Int,
        titleString: String?,
        leftImgVisibility: Boolean,
        @DrawableRes leftImgId: Int,
        rightImgVisibility: Boolean,
        @DrawableRes rightImgId: Int,
        rightTvVisibility: Boolean,
        @StringRes rightTvId: Int,
        headCallback: HeadCallback?
    ) {
        this.headCallback = headCallback
        if (leftImgVisibility) {
            headImgLeft!!.visibility = View.VISIBLE
        } else {
            headImgLeft!!.visibility = View.INVISIBLE
        }
        if (leftImgId != 0) {
            headImgLeft!!.setImageResource(leftImgId)
        }
        if (rightImgVisibility) {
            headImgRight!!.visibility = View.VISIBLE
        } else {
            headImgRight!!.visibility = View.INVISIBLE
        }
        if (rightImgId != 0) {
            headImgRight!!.setImageResource(rightImgId)
        }
        if (rightTvVisibility) {
            tvRight!!.visibility = View.VISIBLE
        } else {
            tvRight!!.visibility = View.INVISIBLE
        }
        if (rightTvId != 0) {
            headImgLeft!!.setImageResource(rightTvId!!)
        }
        headRlRight!!.setOnClickListener(this)
        headTvTitle!!.text = titleString
    }

    fun setData(
        height: Int,
        @DimenRes dimenId: Int,
        @ColorRes colorId: Int,
        titleText: String?,
        leftImgVisibiliy: Boolean,
        @DrawableRes leftImgId: Int,
        rightImgVisibiliy: Boolean,
        @DrawableRes rightImgId: Int,
        rightTvVisibiliy: Boolean,
        @StringRes rightTvId: Int,
        headCallBack: HeadCallback?
    ) {
        headCallback = headCallBack
        if (colorId != 0) {
            headRl!!.setBackgroundColor(resources.getColor(colorId))
        }
        if (leftImgVisibiliy) {
            headImgLeft!!.visibility = View.VISIBLE
        } else {
            headImgLeft!!.visibility = View.INVISIBLE
        }
        if (leftImgId != 0) {
            headImgLeft!!.setImageResource(leftImgId)
        }
        headImgLeft!!.setOnClickListener(this)
        if (rightImgVisibiliy) {
            headImgRight!!.visibility = View.VISIBLE
        } else {
            headImgRight!!.visibility = View.INVISIBLE
        }
        if (rightImgId != 0) {
            headImgRight!!.setImageResource(rightImgId)
        }
        if (rightTvVisibiliy) {
            tvRight!!.visibility = View.VISIBLE
        } else {
            tvRight!!.visibility = View.INVISIBLE
        }
        if (rightTvId != 0) {
            tvRight!!.setText(rightTvId)
        }
        headRlRight!!.setOnClickListener(this)
        if (height != 0) {
            val layoutParams =
                headRl!!.layoutParams as LayoutParams
            layoutParams.height = height
            headRl!!.layoutParams = layoutParams
        }
        if (dimenId != 0) {
            headTvTitle!!.textSize = resources.getDimension(dimenId)
        }
        headTvTitle!!.text = titleText
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun setDataImg(
        @DrawableRes drawableId: Int,
        titleText: String?,
        leftImgVisibility: Boolean,
        @DrawableRes leftImgId: Int,
        rightImgVisibility: Boolean,
        @DrawableRes rightImgId: Int,
        rightTvVisibility: Boolean,
        rightTvText: String?,
        headCallBack: HeadCallback?
    ) {
        headCallback = headCallBack
        if (drawableId != 0) {
            headRl!!.background = resources.getDrawable(drawableId)
        }
        if (leftImgVisibility) {
            headImgLeft!!.visibility = View.VISIBLE
        } else {
            headImgLeft!!.visibility = View.INVISIBLE
        }
        if (leftImgId != 0) {
            headImgLeft!!.setImageResource(leftImgId)
        }
        headImgLeft!!.setOnClickListener(this)
        if (rightImgVisibility) {
            headImgRight!!.visibility = View.VISIBLE
        } else {
            headImgRight!!.visibility = View.INVISIBLE
        }
        if (rightImgId != 0) {
            headImgRight!!.setImageResource(rightImgId)
        }
        if (rightTvVisibility) {
            tvRight!!.visibility = View.VISIBLE
        } else {
            tvRight!!.visibility = View.INVISIBLE
        }
        tvRight!!.text = rightTvText
        headRlRight!!.setOnClickListener(this)
        headTvTitle!!.text = titleText
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun setDataImg(
        height: Int,
        @DimenRes dimenId: Int,
        @DrawableRes drawableId: Int,
        titleText: String?,
        leftVisibility: Boolean,
        @DrawableRes leftImgId: Int,
        rightImgVisibility: Boolean,
        @DrawableRes rightImgId: Int,
        rightTvVisibility: Boolean,
        @StringRes rightTvId: Int,
        headCallBack: HeadCallback?
    ) {
        headCallback = headCallBack
        if (drawableId != 0) {
            headRl!!.background = resources.getDrawable(drawableId, null)
        }
        if (leftVisibility) {
            headImgLeft!!.visibility = View.VISIBLE
        } else {
            headImgLeft!!.visibility = View.INVISIBLE
        }
        if (leftImgId != 0) {
            headImgLeft!!.setImageResource(leftImgId)
        }
        headImgLeft!!.setOnClickListener(this)
        if (rightImgVisibility) {
            headImgRight!!.visibility = View.VISIBLE
        } else {
            headImgRight!!.visibility = View.INVISIBLE
        }
        if (rightImgId != 0) {
            headImgRight!!.setImageResource(rightImgId)
        }
        if (rightTvVisibility) {
            tvRight!!.visibility = View.VISIBLE
        } else {
            tvRight!!.visibility = View.INVISIBLE
        }
        if (rightTvId != 0) {
            tvRight!!.setText(rightTvId)
        }
        headRlRight!!.setOnClickListener(this)
        if (height != 0) {
            val layoutParams =
                headRl!!.layoutParams as LayoutParams
            layoutParams.height = height
            headRl!!.layoutParams = layoutParams
        }
        if (dimenId != 0) {
            headTvTitle!!.textSize = resources.getDimension(dimenId)
        }
        headTvTitle!!.text = titleText
    }

    override fun onClick(v: View) {
        if (headCallback != null) {
            if (v.id == R.id.head_img_left) {
                headCallback!!.onLeftBtnClickListener()
            } else if (v.id == R.id.head_rl_right) {
                headCallback!!.onRightBtnClickListener()
            }
        }
    }
}