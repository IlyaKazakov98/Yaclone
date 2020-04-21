package com.readyfo.yaclone.datasource.local.datasourceimpl

import com.readyfo.yaclone.App
import com.readyfo.yaclone.data.datasource.local.FetchHistoryDataSource
import com.readyfo.yaclone.datasource.local.toHistoryModel
import com.readyfo.yaclone.domain.models.HistoryModel
import io.reactivex.Observable

class FetchHistoryDataSourceImpl :
    FetchHistoryDataSource {
    private val dao by lazy {
        App.yacloneDB.getHistoryDao()
    }

    override fun fetchHistory(): Observable<MutableList<HistoryModel>> = dao.fetchHistory()
        .flatMap { it ->
            Observable.fromIterable(it)
                .map {
                    it.toHistoryModel(it)
                }
                .toList()
                .toObservable()
        }
}