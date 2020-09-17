package com.tgm.common

import com.tgm.base.BaseApplication
import com.tgm.base.config.AppUrlConfig
import com.tgm.net.mgr.UrlMgr


open class CommonApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        UrlMgr.getInstance().setMultipleUrl(AppUrlConfig.getAllUrl())
    }
}