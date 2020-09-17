package com.tgm.base.config

import java.util.HashMap

/**

 * @Author: chen

 * @datetime: 2020/9/16

 * @desc:

 */
open class AppUrlConfig {

    companion object {
        var TGM_DEFAULT_KEY = "tgm_api"
        var OTHER_OPEN_KEY = "other_api"
        var MOCK_KEY = "mock_api"

        val TGM_BASE_URL_DEV = "https://www.wanandroid.com"
        val TGM_BASE_URL_PRO = "https://www.wanandroid.com"
        val TGM_BASE_URL_RC = "https://www.wanandroid.com"

        var OTHER_OPEN_URL = "http://www.baidu.com/"
        var MOCK_URL = "https://yapi.jiliguala.com/mock/83/"

        fun getAllUrl(): HashMap<String, String> {
            val map = HashMap<String, String>()
            map[TGM_DEFAULT_KEY] = if (AppConfig.isModeDev()) TGM_BASE_URL_DEV else if (AppConfig.isModeRc()) TGM_BASE_URL_RC else TGM_BASE_URL_PRO
            map[OTHER_OPEN_KEY] =
                OTHER_OPEN_URL
            map[MOCK_KEY] =
                MOCK_URL
            return map
        }
    }
}