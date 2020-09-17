package com.tgm.base.config

import android.content.Context


object AppConfig {

    private const val MODE_PROD = "prod"
    private const val MODE_DEV = "dev"
    private const val MODE_RC = "rc"

    private var MODE = MODE_PROD  // 测试环境：dev; 预发布换进：rc； 正式环境：prod
    private var DEBUG = true  //区分是debug包还是release
    var SHOW_PHRASE = false //是否展示词组
    var CHANNEL_ID = "TGM_WEBM" //渠道标识
    var COCOS_MODE: String? = null

    fun isModeDev(): Boolean {
        return MODE == MODE_DEV
    }

    fun isModeProd(): Boolean {
        return MODE == MODE_PROD
    }

    fun isModeRc(): Boolean {
        return MODE == MODE_RC
    }

    fun isDebug(): Boolean {
        return DEBUG
    }

    fun getMode(): String {
        return MODE
    }

    fun setModeDev() {
        setMode(MODE_DEV)
    }

    fun setModePro() {
        setMode(MODE_PROD)
    }

    fun setModeRc() {
        setMode(MODE_RC)
    }

    private fun setMode(mode: String) {
        MODE = mode
//        PrefsUtils.mPrefs.edit(true) {
//            putString(PrefsUtils.PREFS_KEY_APP_MODE, mode)
//        }
    }

    fun setCocosMode(mode: String?) {
//        this.COCOS_MODE = mode
//        PrefsUtils.mPrefs.edit(true) {
//            putString(PrefsUtils.PREFS_KEY_COCOS_MODE, mode)
//        }
    }

    fun init(context: Context) {
//        DEBUG = context.applicationInfo.flags.and(ApplicationInfo.FLAG_DEBUGGABLE) != 0
//        PrefsUtils.mPrefs.getString(PrefsUtils.PREFS_KEY_APP_MODE, null)?.let {
//            MODE = it
//        }
//
//        val channel = ChannelReaderUtil.getChannel(context.applicationContext)
//        if (!TextUtils.isEmpty(channel)) {
//            CHANNEL_ID = channel
//        }
//        SHOW_PHRASE = PrefsUtils.mPrefs.getBoolean(PrefsUtils.PREFS_KEY_SHOW_PHRASE, false)
//
//
//        COCOS_MODE = PrefsUtils.mPrefs.getString(PrefsUtils.PREFS_KEY_COCOS_MODE, null)
    }
}

