package com.tgm.net

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Converter
import java.lang.reflect.Type

internal class CoroutineCallAdapter<S : Any, E : Any>(val successBodyType: Type,
                                                      val errorBodyConverter: Converter<ResponseBody, E>,
                                                      val errorInterceptor: IApiErrorInterceptor?)
    : CallAdapter<S, Call<TGMResponse<S, E>>> {

    override fun adapt(call: Call<S>): Call<TGMResponse<S, E>>  = CoroutineCall(call, errorBodyConverter, errorInterceptor)

    override fun responseType(): Type = successBodyType
}