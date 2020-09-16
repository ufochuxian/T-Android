package com.tgm.net

import java.io.IOException


typealias JLGLCommonResponse<S> = TGMResponse<S, CoroutineError>

@NoArg
sealed class TGMResponse<out S : Any, out E : Any> {


    data class Success<S : Any>(val body: S) : TGMResponse<S, Nothing>()

    data class ApiError<E : Any>(val body: E, val code: Int) : TGMResponse<Nothing, E>()


    data class NetworkError(val error: IOException) : TGMResponse<Nothing, Nothing>()

    /**
     * 其他错误，例如json解析错误登录等
     * */
    data class UnknowError(val error: Throwable?) : TGMResponse<Nothing, Nothing>()
}