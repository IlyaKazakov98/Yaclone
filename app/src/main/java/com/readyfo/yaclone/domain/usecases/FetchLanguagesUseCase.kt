package com.readyfo.yaclone.domain.usecases

import com.readyfo.yaclone.domain.models.LanguageModel
import io.reactivex.Single

interface FetchLanguagesUseCase {
    fun fetchLanguages(): Single<List<LanguageModel>>
}