package com.tgm.net

import com.tgm.data.UserInfoEntity
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**

 * @Author: chen

 * @datetime: 2020/9/16

 * @desc:

 */
interface TGMRestApi {

    @GET("/api/user")
    suspend fun getUserV2(): UserInfoEntity

    @POST("user/login")
    suspend fun reister(@Body hasMap: Map<String, String>) :  JLGLCommonResponse<UserInfoEntity>

    @POST("/user/logout/json")
    suspend fun login(@Body hasMap: Map<String, String>): JLGLCommonResponse<UserInfoEntity>

}

//业务报错码
object TGMCode {

    const val CODE_SUCCESS = 0

    const val CODE_AUTH_ERROR = 251067  //所有 auth 接口限制已购买游客账号使用

    const val CODE_VERSION_LOW = 251200 //版本太低报错

    const val UNAUTHENTICATION = 10401

}