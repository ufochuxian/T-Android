package com.tgm.common.ui

import androidx.annotation.ColorInt
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.jaeger.library.StatusBarUtil
import com.tgm.base.mvvm.v.BaseFrameActivity


abstract class BaseActivity<VB : ViewBinding, VM : ViewModel>(vmClass: Class<VM>) :
    BaseFrameActivity<VB, VM>(vmClass) {

    /**
     * 设置状态栏颜色
     */
    protected fun setStatusBarColor(@ColorInt color: Int) {
        StatusBarUtil.setColor(this, color, 0)
    }
}