package com.readyfo.yaclone.di

import com.readyfo.yaclone.di.modules.AppModule
import com.readyfo.yaclone.presentation.ui.fragments.HistoryFragment
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun injectHistoryFragment(historyFragment: HistoryFragment)
}