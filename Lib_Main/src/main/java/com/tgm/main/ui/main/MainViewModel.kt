package com.tgm.main.ui.main

import com.tgm.base.mvvm.vm.BaseViewModel


class MainViewModel : BaseViewModel<MainRepository>() {

    override fun initRepository() = MainRepository()
}