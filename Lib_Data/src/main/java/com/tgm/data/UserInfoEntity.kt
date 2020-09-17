package com.tgm.data

import android.util.Log
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.io.Serializable
import com.tgm.data.UserInfoEntity.UserInfoData

/**

 * @Author: chen

 * @datetime: 2019-11-26

 * @desc:

 */
class UserInfoEntity : BaseEntity<UserInfoData>(), Serializable {


    @Entity(tableName = "user")
    @TypeConverters(BabyConvert::class)
    open class UserInfoData : Serializable {

        @PrimaryKey(autoGenerate = false)
        var _id: String = ""

        var readingSigned: Boolean = false

        var cts: String = ""

        var tok: String = ""

        var b: List<BabiesEntity.BabyEntity> = ArrayList()

        var mobile: String = ""

        var curBid: String? = ""

        var typ: String = ""

        var guaid: String = ""

        var u: String = ""

        var nReadDays: Int = 0

        fun hasBaby(): Boolean {
            b?.let { babies ->
                return babies.isNotEmpty()

            }
            return false
        }

        @Ignore()
        var needAddressOid: String? = null


        var hasBuyGmk: Boolean = false

        @Ignore
        var curBaby: BabiesEntity.BabyEntity? = null
            private set
            get() {
                return this.b.firstOrNull {
                    it._id == this.curBid
                }.apply {
                    Log.e("Frank", "$this")
                }
            }
    }


}

fun UserInfoData.getBabies() = this.b

fun UserInfoData.hasLogin() = this.readingSigned

fun UserInfoData.getCurbid() = this.curBid

fun UserInfoData.getCurBaby(): BabiesEntity.BabyEntity? = this.b.first { it._id == curBid }

fun UserInfoData.isGuest() = "guest".equals(typ, true)