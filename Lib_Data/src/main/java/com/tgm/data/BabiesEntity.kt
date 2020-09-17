package com.tgm.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import kotlin.collections.ArrayList

/**

 * @Author: chen

 * @datetime: 2019-12-03

 * @desc:

 */
class BabiesEntity {

    companion object {

        var paidB: Boolean = false

        var babies: List<BabyEntity> = ArrayList()
    }

    @Entity
    class BabyEntity : Serializable {
        @PrimaryKey
        var _id: String = ""

        var nick: String = ""

        var ava: String = ""

        var bd: String = ""

        var gender: String = ""

        fun isBoy(): Boolean {
            return "boy" == gender
        }

        fun isGirl(): Boolean {
            return "girl" == gender
        }
    }
}