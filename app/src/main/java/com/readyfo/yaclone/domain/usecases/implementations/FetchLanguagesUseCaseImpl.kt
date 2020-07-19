package com.readyfo.yaclone.domain.usecases.implementations

import com.readyfo.yaclone.core.common.BaseUseCase
import com.readyfo.yaclone.domain.repositories.FetchLanguagesRepository
import com.readyfo.yaclone.domain.usecases.FetchLanguagesUseCase

class FetchLanguagesUseCaseImpl(
    private val fetchLanguagesRepository: FetchLanguagesRepository
) : BaseUseCase(), FetchLanguagesUseCase {
    override fun fetchLanguages() = fetchLanguagesRepository.fetchLanguages()
}