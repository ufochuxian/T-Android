package com.tgm.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ServerErrorEntity : Serializable {

    var code = 0
    @SerializedName(value = "msg", alternate = ["err"])
    var msg: String = ""

    override fun toString(): String {
        return "ServerErrorRsp{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}'
    }

}
