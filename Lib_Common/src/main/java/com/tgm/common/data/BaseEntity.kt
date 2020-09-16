package com.tgm.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class BaseEntity<T> : Serializable {

    var code: Int? = 0

    @SerializedName(value = "msg", alternate = ["message"])
    var msg: String? = null

    var data: T? = null

}