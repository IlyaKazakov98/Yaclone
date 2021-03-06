package com.readyfo.yaclone.domain.usecases

import com.readyfo.yaclone.domain.models.HistoryModel
import io.reactivex.Observable

interface FetchHistoryUseCase {
    fun fetchHistory(): Observable<MutableList<HistoryModel>>
}