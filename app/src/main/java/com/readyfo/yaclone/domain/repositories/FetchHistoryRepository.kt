package com.readyfo.yaclone.domain.repositories

import com.readyfo.yaclone.presentation.models.HistoryModel
import io.reactivex.Observable

interface FetchHistoryRepository {
    fun fetchHistory(): Observable<MutableList<HistoryModel>>
}