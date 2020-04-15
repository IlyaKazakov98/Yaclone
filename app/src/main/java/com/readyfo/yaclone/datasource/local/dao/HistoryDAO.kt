package com.readyfo.yaclone.datasource.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.readyfo.yaclone.datasource.local.entity.HistoryEntity
import io.reactivex.Observable

@Dao
interface HistoryDAO {
    @Query("SELECT * FROM history_table")
    fun fetchHistory(): Observable<List<HistoryEntity>>
}