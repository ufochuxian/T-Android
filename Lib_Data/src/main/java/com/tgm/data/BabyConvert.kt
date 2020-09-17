package com.tgm.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**

 * @Author: chen

 * @datetime: 2019-12-05

 * @desc:

 */
class BabyConvert {

    @TypeConverter
    fun stringToObject(value: String): List<BabiesEntity.BabyEntity> {
        val listType = object : TypeToken<List<BabiesEntity.BabyEntity>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun objectToString(list: List<BabiesEntity.BabyEntity>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}