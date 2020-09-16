package com.quyunshuo.main.ui.main

import com.quyunshuo.base.mvvm.vm.BaseViewModel


class MainViewModel : BaseViewModel<MainRepository>() {

    override fun initRepository() = MainRepository()
}