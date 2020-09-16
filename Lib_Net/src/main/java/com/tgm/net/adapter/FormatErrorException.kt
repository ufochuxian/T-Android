package com.tgm.net.adapter

import com.tgm.data.ServerErrorEntity
import java.lang.Exception

class FormatErrorException(var error: ServerErrorEntity) : Exception() {

}