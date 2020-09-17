package com.tgm.main.ui.main

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.tgm.base.mvvm.vm.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext


class MainViewModel : BaseViewModel<MainRepository>() {

    override fun initRepository() = MainRepository()

    fun getData() {
        //newSingleThreadContext("myThread") 重新开启一个线程
        viewModelScope.launch {
            withContext(newSingleThreadContext("myThread")) {
                mRepository.getBaiduData()
            }.let {
                it?.let {
                    Log.v("eric", "response msg:${it.toString()}")
                }
            }
        }
    }
}