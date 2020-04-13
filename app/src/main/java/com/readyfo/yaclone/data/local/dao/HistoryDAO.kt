package com.readyfo.yaclone.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.readyfo.yaclone.data.local.entity.HistoryEntity
import io.reactivex.Observable

@Dao
interface HistoryDAO {
    @Query("SELECT * FROM history_table")
    fun fetchHistory(): Observable<List<HistoryEntity>>
}