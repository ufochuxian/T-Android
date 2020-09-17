package com.tgm.net.interceptor

import android.util.Base64
//import com.jiliguala.library.common.BuildConfig
//import com.jiliguala.library.common.util.DeviceUtil
//import com.jiliguala.library.coremodel.AccountCenter
//import com.jiliguala.library.coremodel.mgr.DeviceIDManager
//import com.jiliguala.library.coremodel.util.EncryptUtil
//import com.jiliguala.log.JLGLLog
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import kotlin.jvm.Throws

/**

 * @Auther: chen

 * @datetime: 2020-09-16

 * @desc:

 */
open class HeaderInterceptor : Interceptor {

    companion object {
//        const val TAG = "HeaderInterceptor"
//        fun getGGHeader(): String {
//            val uid = AccountCenter.instance.getUserUID()
//            val deviceId = DeviceIDManager.instance.getLocalDeviceIdentifyId()
//            val curBid = AccountCenter.instance.getUser()?.curBid
//            val verCode = DeviceUtil.getVersionCode()
//            val verName = DeviceUtil.getVersionName()
//            //统一header定义 https://www.feishu.cn/docs/doccn0KQENel6jXKmfnv9MIONac
//            val headerStr = "$uid|$deviceId|1|$verCode|$verName|$curBid"
//            val base64Str = Base64.encodeToString(headerStr.toByteArray(), Base64.NO_WRAP)
//            var encryptStr = EncryptUtil.encrypt(base64Str)
//            JLGLLog.i(TAG, "uid:${uid},deviceId:${deviceId},verCode:${verCode},verName:${verName},curBid:${curBid}")
//            JLGLLog.i(TAG, "headerStr:%s,base64Str:%s,aesStr:%s", headerStr, base64Str, encryptStr)
//            if (BuildConfig.isModule.toBoolean()) {
//                encryptStr = "txsqBz7ZyAI/ne7BEuJUf8vLcEk1gzN/Xd7WXkhGJYSx5UFFnz6Qgn8+KBPRV/dry9gccP1FptqYlXMq5drSJul+XVfzXP2bYIVXS/TeHDtMu7Fy84jHWmcB0PkKQLu9vkLrmaYLEQfcheEuKwwHr+jklkJwKlPGaMvzWXtgCRywlGoUui5Hs/pGyYZuFLqL5fc1+fLi3irj/DJE"
//            }
//            return encryptStr
//        }
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response? {
//        val originalRequest = chain.request()
//        val builder = originalRequest.newBuilder()
//
//        // add header
//        builder.header("content-type", "application/json")
//                .header("version", "1")
//                .header("Connection", "close")
//                .header("User-Agent", DeviceUtil.defaultUserAgent())
//                .header("accept", "*/*")
//                .header("X-App-Params", String.format("deviceId=%s&deviceType=%s", DeviceUtil.defaultUserAgent(), DeviceUtil.getDeviceName()))
//
//        val uid = AccountCenter.instance.getUserUID()
//        val token = AccountCenter.instance.getUserToken()
//        val encryptStr = getGGHeader()
//        builder.addHeader("GGHeader", encryptStr)
//
//        //add body
//        builder.method(originalRequest.method(), originalRequest.body())
//
//        val credentials = "$uid:$token"
//        // add BasicAuth
//        var basicAuth = "Basic " + Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)
//        if (BuildConfig.isModule.toBoolean()) {
//            basicAuth = "Basic YjY1ZmRlZWQ0ZTg4NDM3NDgwNzY3ZTJkNjQ4YjQ1ZTA6Yzc3YzAwZDA4M2VlNDMyNjlhOGQxNTMzM2MyZjZmYTM="
//        }
//        builder.header("authorization", basicAuth)
//        JLGLLog.i(TAG, "uid:%s,token:%s,basicAuth:%s", uid, token, basicAuth)
////        builder.header("bid","e61a435cf00d4030a904e2b3dcb62827")
//        val request = builder.build()
//        return chain.proceed(request)
        return null

    }
}