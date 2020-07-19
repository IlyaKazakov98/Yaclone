package com.readyfo.yaclone.datasource.local.datasourceimpl

import com.readyfo.yaclone.data.datasource.local.FetchLanguagesLocalDataSource
import com.readyfo.yaclone.datasource.local.dao.LanguagesDAO
import com.readyfo.yaclone.datasource.local.toLanguageModel
import com.readyfo.yaclone.domain.models.LanguageModel
import io.reactivex.Observable

class FetchLanguagesLocalDataSourceImpl(
    private val dao: LanguagesDAO
) : FetchLanguagesLocalDataSource {

    override fun fetchLanguagesFromLocal(): Observable<List<LanguageModel>> = dao.fetchLanguages()
        .flatMap { it ->
            Observable.fromIterable(it)
                .map {
                    it.toLanguageModel(it)
                }
                .toList()
                .toObservable()
        }

//        .map { list ->
//            list.map { lang ->
//                lang.toLanguageModel(lang)
//            }
//        }
}