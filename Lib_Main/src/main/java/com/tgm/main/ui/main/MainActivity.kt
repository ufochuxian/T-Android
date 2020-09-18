package com.tgm.main.ui.main

import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.tgm.common.constant.RouteUrl
import com.tgm.common.ui.BaseActivity
import com.tgm.data.TestData
import com.tgm.main.R
import com.tgm.main.databinding.MainActivityMainBinding


@Route(path = RouteUrl.MainActivity)
class MainActivity :
    BaseActivity<MainActivityMainBinding, MainViewModel>(MainViewModel::class.java) {

    override fun initViewBinding() = MainActivityMainBinding.inflate(layoutInflater)

    override fun initView() {
        setStatusBarColor(resources.getColor(R.color.common_theme_color))
        mViewModel.getData()

        mBinding.apply {
            data = TestData().apply {
                resId = R.drawable.computer
            }
        }
    }

    override fun initViewObserve() {}
}