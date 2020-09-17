package com.tgm.net

import okhttp3.Request
import okhttp3.ResponseBody
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException
import java.lang.UnsupportedOperationException

internal class CoroutineCall<S : Any, E : Any>(val delegate: Call<S>,
                                               val errorBodyConverter: Converter<ResponseBody, E>,
                                               val errorInterceptor: IApiErrorInterceptor?
) : Call<TGMResponse<S, E>> {


    override fun enqueue(callback: Callback<TGMResponse<S, E>>) {
        delegate.enqueue(object : Callback<S> {
            override fun onFailure(call: Call<S>, t: Throwable) {
                val networkResponse  = when (t) {
                    is IOException -> TGMResponse.NetworkError(t)
                    else -> TGMResponse.UnknowError(t)
                }
                callback.onResponse(this@CoroutineCall, Response.success(networkResponse))

            }

            override fun onResponse(call: Call<S>, response: Response<S>) {

                val body = response.body()
                val code = response.code()
                val error = response.errorBody()

                if (response.isSuccessful) {
                    if (body != null) {
                        callback.onResponse(
                                this@CoroutineCall,
                                Response.success(TGMResponse.Success(body))
                        )
                    } else {
                        // Response is successful but the body is null
                        callback.onResponse(
                                this@CoroutineCall,
                                Response.success(TGMResponse.UnknowError(null))
                        )
                    }
                } else {
                    val errorBody = when {
                        error == null -> null
                        error.contentLength() == 0L -> null
                        else -> try {
                            errorBodyConverter.convert(error)
                        } catch (ex: Exception) {
                            null
                        }
                    }
                    if (errorBody != null
                            && errorInterceptor?.interceptApiError(TGMResponse.ApiError(errorBody, code)) == false) {
                        callback.onResponse(
                                this@CoroutineCall,
                                Response.success(TGMResponse.ApiError(errorBody, code))
                        )
                    } else {
                        callback.onResponse(
                                this@CoroutineCall,
                                Response.success(TGMResponse.UnknowError(null))
                        )
                    }
                }

            }

        })
    }

    override fun isExecuted(): Boolean = delegate.isExecuted

    override fun clone(): Call<TGMResponse<S, E>> = CoroutineCall(delegate.clone(), errorBodyConverter, errorInterceptor)

    override fun isCanceled(): Boolean = delegate.isCanceled

    override fun cancel() = delegate.cancel()

    override fun execute(): Response<TGMResponse<S, E>> {
        throw UnsupportedOperationException("Coroutine does not support execute")
    }

    override fun request(): Request = delegate.request()
    override fun timeout(): Timeout {
        TODO("Not yet implemented")
    }
}