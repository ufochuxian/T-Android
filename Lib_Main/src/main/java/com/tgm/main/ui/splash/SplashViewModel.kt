package com.tgm.main.ui.splash

import com.tgm.base.mvvm.vm.BaseViewModel


class SplashViewModel : BaseViewModel<SplashRepository>() {

    override fun initRepository() = SplashRepository()
}