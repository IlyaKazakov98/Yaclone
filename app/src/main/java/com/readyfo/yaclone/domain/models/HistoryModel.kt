package com.readyfo.yaclone.domain.models

data class HistoryModel(
    val id: Int,
    val textFrom: String,
    val textTo: String,
    val languageFrom: String,
    val languageTo: String,
    val favorite: Boolean
)