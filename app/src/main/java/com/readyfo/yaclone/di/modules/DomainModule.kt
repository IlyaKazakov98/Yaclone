package com.readyfo.yaclone.di.modules

import com.readyfo.yaclone.core.CoroutinesDispatcherProvider
import com.readyfo.yaclone.domain.usecases.FetchHistoryUseCase
import com.readyfo.yaclone.domain.usecases.FetchLanguagesUseCase
import com.readyfo.yaclone.domain.usecases.implementations.FetchHistoryUseCaseImpl
import com.readyfo.yaclone.domain.usecases.implementations.FetchLanguagesUseCaseImpl
import org.koin.dsl.module

val domainModule = module{
    single <FetchHistoryUseCase> { FetchHistoryUseCaseImpl(get(), get<CoroutinesDispatcherProvider>().io) }
    single <FetchLanguagesUseCase> { FetchLanguagesUseCaseImpl(get()) }
}