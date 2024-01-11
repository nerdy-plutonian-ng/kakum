package com.plutoapps.kakum.data.models

import com.google.gson.Gson

data class UserData(
    val shouldLoad : Boolean = true,
    val numberOfWins: Int = 0,
    val numberOfLosses: Int = 0,
    val numberOfDaysTilDestruction: Int = 0
) {
    companion object {
        fun getUserDataFromJson(json: String): UserData =
            Gson().fromJson(json, UserData::class.java)
    }

    fun toJson(): String = Gson().toJson(this)
}