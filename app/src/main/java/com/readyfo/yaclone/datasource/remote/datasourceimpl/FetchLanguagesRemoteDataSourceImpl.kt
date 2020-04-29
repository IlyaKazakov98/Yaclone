package com.readyfo.yaclone.datasource.remote.datasourceimpl

import com.readyfo.yaclone.data.datasource.remote.FetchLanguagesRemoteDataSource
import com.readyfo.yaclone.datasource.remote.RetrofitBuilder
import com.readyfo.yaclone.domain.models.LanguageModel
import io.reactivex.Observable

class FetchLanguagesRemoteDataSourceImpl : FetchLanguagesRemoteDataSource {
    private val service by lazy { RetrofitBuilder.getLanguagesService }
    private val ui = "ru"
    private val key =
        "trnsl.1.1.20200415T105628Z.17e529e0fcfa6db1.2851d9def02062e42bbb8a234965353f32b1cbcb"

    override fun fetchLanguagesFromRemote(): Observable<List<LanguageModel>> =
        service.getLanguages(ui, key)
            .flatMap { it ->
                val obj = it.languages
                val keys = obj.keySet()

                Observable.fromIterable(keys)
                    .map { key ->
                        val language = obj.get(key).asString

                        LanguageModel(
                            key = key,
                            language = language
                        )
                    }
                    .toList()
                    .toObservable()
            }
}