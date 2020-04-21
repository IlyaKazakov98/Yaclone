package com.readyfo.yaclone.di

import com.readyfo.yaclone.di.modules.ChoseLanguageModule
import com.readyfo.yaclone.di.modules.HistoryModule
import com.readyfo.yaclone.presentation.choselang.ChoseLangFragment
import com.readyfo.yaclone.presentation.history.HistoryFragment
import dagger.Component

@Component(modules = [ChoseLanguageModule::class, HistoryModule::class])
interface AppComponent {
    fun injectHistoryFragment(historyFragment: HistoryFragment)
    fun injectChoseLangFragment(choseLangFragment: ChoseLangFragment)
}