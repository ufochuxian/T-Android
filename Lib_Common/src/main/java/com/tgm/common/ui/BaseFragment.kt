package com.tgm.common.ui

import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.tgm.base.mvvm.v.BaseFrameFragment


abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(vmClass: Class<VM>) :
    BaseFrameFragment<VB, VM>(vmClass)