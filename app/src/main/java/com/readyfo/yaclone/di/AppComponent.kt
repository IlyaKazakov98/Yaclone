package com.readyfo.yaclone.di

import com.readyfo.yaclone.App
import com.readyfo.yaclone.di.modules.DataModule
import com.readyfo.yaclone.di.modules.DataSourceModule
import com.readyfo.yaclone.di.modules.DomainModule
import com.readyfo.yaclone.di.modules.RoomModule
import com.readyfo.yaclone.presentation.choselang.ChoseLangFragment
import com.readyfo.yaclone.presentation.history.HistoryFragment
import dagger.Component
import javax.inject.Singleton


@Component(modules = [DomainModule::class, DataModule::class, DataSourceModule::class, RoomModule::class])
@Singleton
interface AppComponent {
    fun injectApp(app: App)
    fun injectHistoryFragment(historyFragment: HistoryFragment)
    fun injectChoseLangFragment(choseLangFragment: ChoseLangFragment)
}