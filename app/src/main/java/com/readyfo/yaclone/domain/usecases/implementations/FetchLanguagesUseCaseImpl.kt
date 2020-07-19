package com.readyfo.yaclone.domain.usecases.implementations

import com.readyfo.yaclone.domain.repositories.FetchLanguagesRepository
import com.readyfo.yaclone.domain.usecases.FetchLanguagesUseCase

class FetchLanguagesUseCaseImpl(
    private val fetchLanguagesRepository: FetchLanguagesRepository
) : FetchLanguagesUseCase {
    override fun fetchLanguages() = fetchLanguagesRepository.fetchLanguages()
}