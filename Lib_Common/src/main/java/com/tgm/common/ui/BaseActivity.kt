package com.tgm.common.ui

import androidx.annotation.ColorInt
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.jaeger.library.StatusBarUtil
import com.tgm.base.mvvm.v.BaseFrameActivity


abstract class BaseActivity<VB : ViewDataBinding, VM : ViewModel>(vmClass: Class<VM>) :
    BaseFrameActivity<VB, VM>(vmClass) {

    /**
     * 设置状态栏颜色
     */
    protected fun setStatusBarColor(@ColorInt color: Int) {
        StatusBarUtil.setColor(this, color, 0)
    }
}