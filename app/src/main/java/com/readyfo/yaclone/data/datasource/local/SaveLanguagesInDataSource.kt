package com.readyfo.yaclone.data.datasource.local

import com.readyfo.yaclone.domain.models.LanguageModel

interface SaveLanguagesInDataSource {
    fun saveLanguagesInDataBase(languages: List<LanguageModel>)
}