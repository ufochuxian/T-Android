package com.tgm.common.ui

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.tgm.base.mvvm.v.BaseFrameFragment


abstract class BaseFragment<VB : ViewDataBinding, VM : ViewModel>(vmClass: Class<VM>) :
    BaseFrameFragment<VB, VM>(vmClass)