package com.tgm.net.adapter

import com.google.gson.Gson
import com.google.gson.GsonBuilder

/**

 * @Auther: chen

 * @datetime: 2019-11-07

 * @desc:

 */
class GsonAdapter {

    companion object {

        fun buildGson(): Gson {
            val gson =
                    return GsonBuilder().registerTypeAdapter(Int::class.java, IntegerDefault0Adapter())
                            .registerTypeAdapter(Int::class.java, IntegerDefault0Adapter())
                            .registerTypeAdapter(Double::class.java, DoubleDefault0Adapter())
                            .registerTypeAdapter(Double::class.java, DoubleDefault0Adapter())
                            .registerTypeAdapter(Long::class.java, LongDefault0Adapter())
                            .registerTypeAdapter(Long::class.java, LongDefault0Adapter())
                            .create()
        }
    }

}