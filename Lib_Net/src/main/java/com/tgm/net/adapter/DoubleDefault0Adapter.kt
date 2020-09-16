package com.tgm.net.adapter

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import com.google.gson.JsonSyntaxException

import java.lang.reflect.Type
import kotlin.jvm.Throws


class DoubleDefault0Adapter : JsonSerializer<Double>, JsonDeserializer<Double> {
    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Double? {
        try {
            if (json.asString == "" || json.asString == "null") {
                return 0.00
            }
        } catch (ignore: Exception) {
        }

        try {
            return json.asDouble
        } catch (e: NumberFormatException) {
            throw JsonSyntaxException(e)
        }

    }

    override fun serialize(src: Double?, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
        return JsonPrimitive(src!!)
    }
}