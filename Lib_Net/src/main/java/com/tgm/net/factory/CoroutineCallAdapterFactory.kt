package com.tgm.net.factory

import com.tgm.net.CoroutineCallAdapter
import com.tgm.net.IApiErrorInterceptor
import com.tgm.net.TGMResponse
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class CoroutineCallAdapterFactory(var errorInterceptor: IApiErrorInterceptor? = null) : CallAdapter.Factory() {


    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {

        if (retrofit2.Call::class.java != getRawType(returnType)) {
            return null
        }

        check(returnType is ParameterizedType) {
            "return type must be parameterized as Call<JLGLResponse<BaseEntity<Foo>>>"
        }


        val responseType = getParameterUpperBound(0, returnType)

        if (TGMResponse::class.java != getRawType(responseType)) {
            return null
        }



        check(responseType is ParameterizedType) {
            "response type must be parameterized as JLGLResponse<BaseEntity<Foo>>"
        }

        val successBodyType = getParameterUpperBound(0, responseType)
        val errorBodyType = getParameterUpperBound(1, responseType)


        val errorBodyConverter = retrofit.nextResponseBodyConverter<Any>(null, errorBodyType, annotations)


        return CoroutineCallAdapter<Any, Any>(successBodyType, errorBodyConverter, errorInterceptor)


    }


}