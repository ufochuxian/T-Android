package com.tgm.net.adapter

import com.google.gson.*
import java.lang.reflect.Type

/**

 * @Auther: chen

 * @datetime: 2019-11-07

 * @desc:

 */
class IntegerDefault0Adapter : JsonSerializer<Integer>, JsonDeserializer<Integer> {

    override fun serialize(src: Integer?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        return JsonPrimitive(src)
    }

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Integer {
        if(json?.asString == "" || json?.asString == "null") {
            return Integer(0)
        }
        return json?.asInt as Integer
    }
}