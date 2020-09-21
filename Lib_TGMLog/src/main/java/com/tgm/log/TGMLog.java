package com.tgm.log;


import timber.log.Timber;


public class TGMLog {

    public static final String TAG = "TGMLog";
    public static boolean enableLogging = true;

    static {
        Timber.plant(new Timber.DebugTree());
    }


    public static void setEnableLogging(boolean enable) {
        enableLogging = enable;
    }

    /**
     * VERBOSE格式化日志输出
     *
     * @param tagName
     * @param format
     * @param logMsg
     */
    public static final void v(final String tagName, final String format, final Object... logMsg) {
        if (enableLogging) {
            Timber.tag(tagName).v(format, logMsg);
        }

    }

    /**
     * DEBUG格式化日志输出
     *
     * @param tagName
     * @param format
     * @param logMsg
     */
    public static final void d(final String tagName, final String format, final Object... logMsg) {
        if (enableLogging) {
            Timber.tag(tagName).d(format, logMsg);
        }

    }

    /**
     * INFO日志格式化输出
     *
     * @param tagName
     * @param format
     * @param logMsg
     */
    public static final void i(final String tagName, final String format, final Object... logMsg) {
        if (enableLogging) {
            Timber.tag(tagName).i(format, logMsg);
        }

    }

    /**
     * WARN日志格式化输出
     *
     * @param tagName
     * @param format
     * @param logMsg
     */
    public static final void w(final String tagName, final String format, final Object... logMsg) {
        if (enableLogging) {
            Timber.tag(tagName).w(format, logMsg);
        }
    }

    /**
     * WARN日志格式化输出
     *
     * @param tagName
     * @param format
     * @param tr
     * @param logMsg
     */
    public static final void w(final String tagName, final String format, final Throwable tr, final Object... logMsg) {
        if (enableLogging) {
            Timber.tag(tagName).w(tr, format, logMsg);
        }
    }

    /**
     * ERROR日志格式化输出
     *
     * @param tagName
     * @param format
     * @param logMsg
     */
    public static final void e(final String tagName, final String format, final Object... logMsg) {
        if (enableLogging) {
            Timber.tag(tagName).e(format, logMsg);
        }
    }

    public static final void e(final String tagName, final String format, final Throwable tr, final Object... logMsg) {
        if (enableLogging) {
            Timber.tag(tagName).e(tr, format, logMsg);
        }
    }
}
