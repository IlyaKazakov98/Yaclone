package com.readyfo.yaclone.domain.repositories

import com.readyfo.yaclone.domain.models.HistoryModel
import io.reactivex.Observable

interface FetchHistoryRepository {
    fun fetchHistory(): Observable<MutableList<HistoryModel>>
}