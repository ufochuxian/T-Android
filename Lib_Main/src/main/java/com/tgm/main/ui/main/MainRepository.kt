package com.tgm.main.ui.main

import android.util.Log
import com.tgm.base.mvvm.m.BaseRepository
import com.tgm.data.UserInfoEntity
import com.tgm.net.ApiMgr
import com.tgm.net.TGMResponse
import com.tgm.net.TGMRestApi

class MainRepository : BaseRepository() {


    suspend fun getBaiduData() : UserInfoEntity? {

        var map = HashMap<String, String>()
        map["username"] = "eric"
        map["password"] = "158158"
        val login = ApiMgr.instance.createApi(TGMRestApi::class.java).reister(map)

        return if (login is TGMResponse.Success) {
            Log.v("MainRepository", "login:${login.body.code}")
            login.body
        } else {
            Log.v("MainRepository", "login:${login}")
            null
        }
    }


}