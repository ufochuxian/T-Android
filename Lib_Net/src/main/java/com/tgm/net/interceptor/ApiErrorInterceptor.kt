package com.tgm.net.interceptor

import android.os.Handler
import android.os.Looper
import com.alibaba.android.arouter.launcher.ARouter
import com.tgm.net.CoroutineError
import com.tgm.net.IApiErrorInterceptor
import com.tgm.net.TGMCode
import com.tgm.net.TGMResponse


class ApiErrorInterceptor : IApiErrorInterceptor {

    override fun interceptApiError(apiError: TGMResponse.ApiError<Any>): Boolean {
        if (apiError.body is CoroutineError) {
            val error = apiError.body as CoroutineError
            when (error.code) {
                TGMCode.UNAUTHENTICATION -> {

                    return true
                }

                TGMCode.CODE_AUTH_ERROR -> {

                    return true
                }

                TGMCode.CODE_VERSION_LOW -> {
//                    Handler(Looper.getMainLooper()).post { showLongWithIcon("当前版本太低，请更新客户端", false) }
                    return true
                }

                else -> {
                    return false
                }

            }
        }

        return false
    }
}