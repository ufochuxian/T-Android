package com.tgm.net

import android.app.Application
import android.content.Context

/**

 * @Author: chen

 * @datetime: 2020/09/16

 * @desc:

 */
class ApiMgr {

    private lateinit var context: Application

    companion object {
        val instance: ApiMgr by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { ApiMgr() }
    }

    open fun init(ctx: Application): ApiMgr {
        context = ctx
        ApiFactory.instance.setContext(ctx)
        return this
    }

    open fun getContext(): Context {
        return context
    }

    /**
     * 使用全局参数创建请求
     *
     */

    open fun <K> createApi(cls: Class<K>): K {
        return ApiFactory.instance.createApi(cls)

    }


    /**
     * mock api
     */
    fun <K> createMockApi(cls: Class<K>): K {
        return ApiFactory.instance.createMockApi(cls)
    }

}