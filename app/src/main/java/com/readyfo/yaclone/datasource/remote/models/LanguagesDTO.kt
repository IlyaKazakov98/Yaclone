package com.readyfo.yaclone.datasource.remote.models


import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class LanguagesDTO(
    @SerializedName("langs")
    val languages: JsonObject
)