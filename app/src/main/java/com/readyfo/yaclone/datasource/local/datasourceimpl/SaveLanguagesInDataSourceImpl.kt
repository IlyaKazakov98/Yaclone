package com.readyfo.yaclone.datasource.local.datasourceimpl

import com.readyfo.yaclone.App
import com.readyfo.yaclone.data.datasource.local.SaveLanguagesInDataSource
import com.readyfo.yaclone.datasource.local.toLanguagesEntity
import com.readyfo.yaclone.domain.models.LanguageModel

class SaveLanguagesInDataSourceImpl : SaveLanguagesInDataSource {
    private val dao by lazy {
        App.yacloneDB.getLanguagesDao()
    }

    override fun saveLanguagesInDataBase(languages: List<LanguageModel>) {
        dao.saveLanguages(languages.toLanguagesEntity(languages))
    }
}