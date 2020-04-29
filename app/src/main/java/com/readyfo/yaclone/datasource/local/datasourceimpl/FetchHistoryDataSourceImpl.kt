package com.readyfo.yaclone.datasource.local.datasourceimpl

import com.readyfo.yaclone.data.datasource.local.FetchHistoryDataSource
import com.readyfo.yaclone.datasource.local.dao.HistoryDAO
import com.readyfo.yaclone.datasource.local.toHistoryModel
import com.readyfo.yaclone.domain.models.HistoryModel
import io.reactivex.Observable
import javax.inject.Inject

class FetchHistoryDataSourceImpl @Inject constructor(private val dao: HistoryDAO) :
    FetchHistoryDataSource {

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