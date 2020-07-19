package com.readyfo.yaclone.di.modules

import com.readyfo.yaclone.core.CoroutinesDispatcherProvider
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val appModule = module {
    single { CoroutinesDispatcherProvider(Dispatchers.Main, Dispatchers.Default, Dispatchers.IO) }
}