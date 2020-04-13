package com.readyfo.yaclone.domain.usecases.implementations

import com.readyfo.yaclone.domain.repositories.FetchHistoryRepository
import com.readyfo.yaclone.domain.usecases.FetchHistoryUseCase
import javax.inject.Inject

class FetchHistoryUseCaseImpl @Inject constructor(val fetchHistoryRepository: FetchHistoryRepository) :
    FetchHistoryUseCase {
    override fun fetchHistory() = fetchHistoryRepository.fetchHistory()
}