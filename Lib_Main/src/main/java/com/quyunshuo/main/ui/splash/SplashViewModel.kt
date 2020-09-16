package com.quyunshuo.main.ui.splash

import com.quyunshuo.base.mvvm.vm.BaseViewModel


class SplashViewModel : BaseViewModel<SplashRepository>() {

    override fun initRepository() = SplashRepository()
}