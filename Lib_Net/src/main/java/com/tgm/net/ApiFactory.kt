package com.tgm.net

import android.content.Context
import com.tgm.base.config.AppUrlConfig
import com.tgm.net.builder.RetrofitBuilder

import com.tgm.net.mgr.UrlMgr
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import java.util.*

/**

 * @Auther: chen

 * @datetime: 2020/09/16

 * @desc:

 */
class ApiFactory private constructor() {

    /**
     *
     * 缓存retrofit针对同一个域名下相同的ApiService不用重复创建
     */

    private val apiServiceCache: HashMap<String, Any> = HashMap()

    private lateinit var mCtx: Context

    private var mCallAdapterFactory: CallAdapter.Factory? = null

    private var mConvertFactory: Converter.Factory? = null

    private var okHttpClient: OkHttpClient? = null


    open fun setContext(ctx: Context) {
        this.mCtx = ctx
    }


    open fun setOkHttpclient(client: OkHttpClient) {
        this.okHttpClient = client
    }

    companion object {
        val instance: ApiFactory by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { ApiFactory() }
    }


    fun setCallAdapterFactory(callAdapterFactory: CallAdapter.Factory): ApiFactory {
        this.mCallAdapterFactory = callAdapterFactory
        return this
    }

    fun setConvertFactory(convertFactory: Converter.Factory) {
        this.mConvertFactory = convertFactory
    }

    open fun <A> createApi(apiClass: Class<A>): A {
        val defaultUrlKey = AppUrlConfig.TGM_DEFAULT_KEY
        val defaultUrlValue = UrlMgr.getInstance().getUrlByKey(defaultUrlKey)
        return createApi(defaultUrlKey, defaultUrlValue, apiClass)
    }

    fun <A> createMockApi(apiClass: Class<A>): A {
        val key = AppUrlConfig.MOCK_KEY
        val value = UrlMgr.getInstance().getUrlByKey(key)
        return createApi(key, value, apiClass)
    }

    private fun <A> createApi(baseUrlKey: String, baseUrlValue: String?, apiClass: Class<A>): A {
        val key = getApiKey(baseUrlKey, apiClass)
        var api = apiServiceCache[key] as A
        if (api == null) {
            var retrofit = RetrofitBuilder()
                    .setBaeUrl(baseUrlValue)
                    .setCallAdapterFactory(mCallAdapterFactory)
                    .setConvertFactory(mConvertFactory)
                    .setOkHttpClient(okHttpClient)
                    .build()
            api = retrofit.create(apiClass)
        }
        apiServiceCache[key] = api as Any
        return api
    }

    private fun <A> getApiKey(baseUrlKey: String, apiClass: Class<A>): String {
        return String.format("%s_%s", baseUrlKey, apiClass)
    }

}