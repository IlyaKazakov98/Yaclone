package com.readyfo.yaclone.datasource.local.datasourceimpl

import com.readyfo.yaclone.App
import com.readyfo.yaclone.data.datasource.local.FetchLanguagesLocalDataSource
import com.readyfo.yaclone.datasource.local.toLanguageModel
import com.readyfo.yaclone.domain.models.LanguageModel
import io.reactivex.Observable

class FetchLanguagesLocalDataSourceImpl : FetchLanguagesLocalDataSource {
    private val dao by lazy {
        App.yacloneDB.getLanguagesDao()
    }

    override fun fetchLanguagesFromLocal(): Observable<List<LanguageModel>> = dao.fetchLanguages()
        .flatMap { it ->
            Observable.fromIterable(it)
                .map {
                    it.toLanguageModel(it)
                }
                .toList()
                .toObservable()
        }
}