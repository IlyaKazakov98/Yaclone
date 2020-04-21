package com.readyfo.yaclone.datasource.local

import com.readyfo.yaclone.datasource.local.entity.HistoryEntity
import com.readyfo.yaclone.datasource.local.entity.LanguageEntity
import com.readyfo.yaclone.domain.models.HistoryModel
import com.readyfo.yaclone.domain.models.LanguageModel

fun HistoryEntity.toHistoryModel(historyEntity: HistoryEntity) =
    HistoryModel(
        id = historyEntity.id,
        textFrom = historyEntity.textFrom,
        textTo = historyEntity.textTo,
        languageFrom = historyEntity.languageFrom,
        languageTo = historyEntity.languageTo,
        favorite = historyEntity.favorite
    )

fun LanguageEntity.toLanguageModel(languageEntity: LanguageEntity) =
    LanguageModel(
        id = languageEntity.id,
        key = languageEntity.key,
        language = languageEntity.language
    )

fun List<LanguageModel>.toLanguagesEntity(languages: List<LanguageModel>): List<LanguageEntity> {
    val languagesEntity: MutableList<LanguageEntity> = mutableListOf()

    for (language in languages) {
        languagesEntity.add(
            LanguageEntity(
                id = 0,
                key = language.key,
                language = language.language
            )
        )
    }
    return languagesEntity
}