package com.readyfo.yaclone.data

import com.readyfo.yaclone.data.datasource.local.FetchHistoryDataSource
import com.readyfo.yaclone.domain.repositories.FetchHistoryRepository
import javax.inject.Inject

class FetchHistoryRepositoryImpl @Inject constructor(
     val fetchHistoryDataSource: FetchHistoryDataSource
) : FetchHistoryRepository {

    override fun fetchHistory() = fetchHistoryDataSource.fetchHistory()
}