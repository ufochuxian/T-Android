package com.tgm.net.builder

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.tgm.net.adapter.GsonAdapter
import com.tgm.net.factory.CoroutineCallAdapterFactory
import com.tgm.net.interceptor.ApiErrorInterceptor
import com.tgm.net.interceptor.HeaderInterceptor
import com.tgm.net.interceptor.HttpLogger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**

 * @Auther: chen

 * @datetime: 2020-09-16

 * @desc:

 */
class RetrofitBuilder {

    private var baseUrl: String? = ""

    private var callAdapterFactory: CallAdapter.Factory? = null

    private var convertFactory: Converter.Factory? = null

    private var okHttpClient: OkHttpClient? = null


    open fun setBaeUrl(baseUrl: String?): RetrofitBuilder {
        this.baseUrl = baseUrl
        return this
    }

    open fun setCallAdapterFactory(factory: CallAdapter.Factory?): RetrofitBuilder {
        this.callAdapterFactory = factory
        return this
    }

    open fun setConvertFactory(factory: Converter.Factory?): RetrofitBuilder {
        this.convertFactory = factory
        return this
    }

    open fun setOkHttpClient(client: OkHttpClient?): RetrofitBuilder {
        this.okHttpClient = client
        return this
    }

    open fun build(): Retrofit {
        var builder = Retrofit.Builder()

        builder.baseUrl(baseUrl)

        // add calladater factory
//        builder.addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
        builder.addCallAdapterFactory(CoroutineCallAdapterFactory(ApiErrorInterceptor()))

        // add error process factory
        if (callAdapterFactory != null) {
            builder.addCallAdapterFactory(callAdapterFactory)
        }

        // add convert factory
        if (convertFactory == null) {
            builder.addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(GsonAdapter.buildGson()))
        } else {
            builder.addConverterFactory(convertFactory)
        }

        if (okHttpClient == null) {
            builder.client(createOkHttpClient())
        } else {
            builder.client(okHttpClient)
        }

        return builder.build()

    }

    private fun createOkHttpClient(): OkHttpClient {

        val loggingInterceptor = HttpLoggingInterceptor(HttpLogger())
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        var builder = OkHttpClient.Builder()
        builder.addNetworkInterceptor(StethoInterceptor()).build()
        builder.readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(HeaderInterceptor())
                .addNetworkInterceptor(StethoInterceptor())
        /*val sslParams = SSLUtils.getSslSocketFactory()
        builder.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)*/

        return builder.build()
    }

}