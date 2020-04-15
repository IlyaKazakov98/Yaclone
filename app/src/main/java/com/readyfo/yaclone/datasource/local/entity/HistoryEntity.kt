package com.readyfo.yaclone.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_table")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "textFrom")
    val textFrom: String,
    @ColumnInfo(name = "textTo")
    val textTo: String,
    @ColumnInfo(name = "languageFrom")
    val languageFrom: String,
    @ColumnInfo(name = "languageTo")
    val languageTo: String,
    @ColumnInfo(name = "favorite")
    val favorite: Boolean
)