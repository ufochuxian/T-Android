package debug

import com.tgm.common.CommonApplication
import com.tgm.log.TGMLog
import com.tgm.main.BuildConfig

class MainApplication : CommonApplication() {

    override fun onCreate() {
        super.onCreate()
        TGMLog.enableLogging = BuildConfig.DEBUG
    }
}