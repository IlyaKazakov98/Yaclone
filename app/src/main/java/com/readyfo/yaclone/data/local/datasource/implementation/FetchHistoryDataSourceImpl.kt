package com.readyfo.yaclone.data.local.datasource.implementation

import com.readyfo.yaclone.App
import com.readyfo.yaclone.data.local.datasource.FetchHistoryDataSource
import com.readyfo.yaclone.presentation.models.HistoryModel
import io.reactivex.Observable

class FetchHistoryDataSourceImpl : FetchHistoryDataSource {
    private val dao by lazy {
        App.yacloneDB.getHistoryDao()
    }

    override fun fetchHistory(): Observable<MutableList<HistoryModel>> = dao.fetchHistory()
        .flatMap { it ->
            Observable.fromIterable(it)
                .map {
                    HistoryModel(
                        id = it.id,
                        textFrom = it.textFrom,
                        textTo = it.textTo,
                        languageFrom = it.languageFrom,
                        languageTo = it.languageTo,
                        favorite = it.favorite
                    )
                }
                .toList()
                .toObservable()
        }
}