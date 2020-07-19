package com.readyfo.yaclone.data

import com.readyfo.yaclone.data.datasource.local.FetchHistoryDataSource
import com.readyfo.yaclone.domain.repositories.FetchHistoryRepository

class FetchHistoryRepositoryImpl(
    private val fetchHistoryDataSource: FetchHistoryDataSource
) : FetchHistoryRepository {

    override fun fetchHistory() = fetchHistoryDataSource.fetchHistory()
}