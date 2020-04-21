package com.readyfo.yaclone.data.datasource.local

import com.readyfo.yaclone.domain.models.LanguageModel
import io.reactivex.Observable

interface FetchLanguagesLocalDataSource {
    fun fetchLanguagesFromLocal(): Observable<List<LanguageModel>>
}