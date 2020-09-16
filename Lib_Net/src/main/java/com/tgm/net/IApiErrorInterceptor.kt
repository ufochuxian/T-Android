package com.tgm.net

interface IApiErrorInterceptor {


    fun interceptApiError(apiError: TGMResponse.ApiError<Any>): Boolean
}