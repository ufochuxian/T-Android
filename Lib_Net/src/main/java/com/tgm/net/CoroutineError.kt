package com.tgm.net

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CoroutineError : Serializable {

    var code = 0

    @SerializedName(value = "msg", alternate = ["err"])
    var msg: String = ""

    override fun toString(): String {
        return "CoroutineError{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}'
    }
}