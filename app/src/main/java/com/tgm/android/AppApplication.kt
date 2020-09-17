package com.tgm.android

import com.tgm.common.CommonApplication
import com.tgm.net.ApiMgr
import org.greenrobot.eventbus.EventBus

class AppApplication : CommonApplication() {

    override fun initialize() {
        // 开启EventBusAPT,优化反射效率
        EventBus
            .builder()
//            .addIndex()
            .installDefaultEventBus()
        super.initialize()

        ApiMgr.instance.init(this)
    }


}