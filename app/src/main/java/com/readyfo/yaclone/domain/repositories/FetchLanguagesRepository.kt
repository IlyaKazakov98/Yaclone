package com.readyfo.yaclone.domain.repositories

import com.readyfo.yaclone.domain.models.LanguageModel
import io.reactivex.Single

interface FetchLanguagesRepository {
    fun fetchLanguages(): Single<List<LanguageModel>>
}