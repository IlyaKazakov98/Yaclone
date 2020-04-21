package com.readyfo.yaclone.data.datasource.remote

import com.readyfo.yaclone.domain.models.LanguageModel
import io.reactivex.Observable

interface FetchLanguagesRemoteDataSource {
    fun fetchLanguagesFromRemote(): Observable<List<LanguageModel>>
}