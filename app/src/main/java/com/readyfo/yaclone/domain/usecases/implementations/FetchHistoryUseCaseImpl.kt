package com.readyfo.yaclone.domain.usecases.implementations

import com.readyfo.yaclone.core.common.BaseUseCase
import com.readyfo.yaclone.domain.repositories.FetchHistoryRepository
import com.readyfo.yaclone.domain.usecases.FetchHistoryUseCase
import kotlinx.coroutines.CoroutineDispatcher

class FetchHistoryUseCaseImpl(
    private val fetchHistoryRepository: FetchHistoryRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase(dispatcher), FetchHistoryUseCase {
    override fun fetchHistory() = fetchHistoryRepository.fetchHistory()
}