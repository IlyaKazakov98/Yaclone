package com.readyfo.yaclone

import android.app.Application
import com.readyfo.yaclone.datasource.remote.RetrofitBuilder
import com.readyfo.yaclone.di.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        RetrofitBuilder.createLanguagesService()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            androidLogger()

            modules(
                appModule,
                presentationModule,
                domainModule,
                dataModule,
                dataSourceModule,
                localModule
            )
        }
    }
}