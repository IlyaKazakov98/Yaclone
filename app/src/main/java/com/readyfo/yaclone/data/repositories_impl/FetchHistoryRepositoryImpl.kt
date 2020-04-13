package com.readyfo.yaclone.data.repositories_impl

import com.readyfo.yaclone.data.local.datasource.FetchHistoryDataSource
import com.readyfo.yaclone.domain.repositories.FetchHistoryRepository
import javax.inject.Inject

class FetchHistoryRepositoryImpl @Inject constructor(
     val fetchHistoryDataSource: FetchHistoryDataSource
) : FetchHistoryRepository {

    override fun fetchHistory() = fetchHistoryDataSource.fetchHistory()
}