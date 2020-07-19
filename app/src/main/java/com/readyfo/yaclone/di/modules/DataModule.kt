package com.readyfo.yaclone.di.modules

import com.readyfo.yaclone.data.FetchHistoryRepositoryImpl
import com.readyfo.yaclone.data.FetchLanguagesRepositoryImpl
import com.readyfo.yaclone.domain.repositories.FetchHistoryRepository
import com.readyfo.yaclone.domain.repositories.FetchLanguagesRepository
import org.koin.dsl.module

val dataModule = module {
    single<FetchHistoryRepository> { FetchHistoryRepositoryImpl(get()) }
    single<FetchLanguagesRepository> { FetchLanguagesRepositoryImpl(get(), get(), get()) }
}