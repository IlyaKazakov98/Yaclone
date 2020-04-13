package com.readyfo.yaclone.data.local.datasource

import com.readyfo.yaclone.presentation.models.HistoryModel
import io.reactivex.Observable

interface FetchHistoryDataSource {
    fun fetchHistory(): Observable<MutableList<HistoryModel>>
}