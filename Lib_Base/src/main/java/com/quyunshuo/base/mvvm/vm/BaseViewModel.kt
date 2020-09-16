package com.quyunshuo.base.mvvm.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quyunshuo.base.mvvm.m.BaseRepository


abstract class BaseViewModel<R : BaseRepository> : ViewModel() {

    // Loading 状态
    val isLoading = MutableLiveData(false)

    protected val mRepository: R by lazy { initRepository() }

    protected abstract fun initRepository(): R
}