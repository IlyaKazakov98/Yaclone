package com.readyfo.yaclone.domain.usecases.implementations

import com.readyfo.yaclone.domain.repositories.FetchHistoryRepository
import com.readyfo.yaclone.domain.usecases.FetchHistoryUseCase

class FetchHistoryUseCaseImpl(
    private val fetchHistoryRepository: FetchHistoryRepository
) : FetchHistoryUseCase {
    override fun fetchHistory() = fetchHistoryRepository.fetchHistory()
}