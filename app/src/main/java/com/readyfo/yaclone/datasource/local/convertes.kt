package com.readyfo.yaclone.datasource.local

import com.readyfo.yaclone.datasource.local.entity.HistoryEntity
import com.readyfo.yaclone.domain.models.HistoryModel

fun HistoryEntity.toHistoryModel(historyEntity: HistoryEntity) =
    HistoryModel(
        id = historyEntity.id,
        textFrom = historyEntity.textFrom,
        textTo = historyEntity.textTo,
        languageFrom = historyEntity.languageFrom,
        languageTo = historyEntity.languageTo,
        favorite = historyEntity.favorite
    )