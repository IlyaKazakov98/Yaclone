package com.readyfo.yaclone.datasource.local.datasourceimpl

import com.readyfo.yaclone.data.datasource.local.SaveLanguagesInDataSource
import com.readyfo.yaclone.datasource.local.dao.LanguagesDAO
import com.readyfo.yaclone.datasource.local.toLanguagesEntity
import com.readyfo.yaclone.domain.models.LanguageModel
import javax.inject.Inject

class SaveLanguagesInDataSourceImpl @Inject constructor(private val dao: LanguagesDAO) :
    SaveLanguagesInDataSource {

    override fun saveLanguagesInDataBase(languages: List<LanguageModel>) {
        dao.saveLanguages(languages.toLanguagesEntity(languages))
    }
}