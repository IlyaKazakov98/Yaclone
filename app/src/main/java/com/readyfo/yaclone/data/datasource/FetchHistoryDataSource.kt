package com.readyfo.yaclone.data.datasource

import com.readyfo.yaclone.domain.models.HistoryModel
import io.reactivex.Observable

interface FetchHistoryDataSource {
    fun fetchHistory(): Observable<MutableList<HistoryModel>>
}