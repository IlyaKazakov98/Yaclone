package com.readyfo.yaclone.di.modules

import com.readyfo.yaclone.presentation.choselang.ChoseLangViewModel
import com.readyfo.yaclone.presentation.history.HistoryViewModel
import com.readyfo.yaclone.presentation.translator.TranslatorViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { TranslatorViewModel() }
    viewModel { HistoryViewModel(get()) }
    viewModel { ChoseLangViewModel(get()) }
}