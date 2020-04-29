package com.readyfo.yaclone

import android.app.Application
import android.content.Context
import com.readyfo.yaclone.datasource.remote.RetrofitBuilder
import com.readyfo.yaclone.di.AppComponent
import com.readyfo.yaclone.di.DaggerAppComponent
import com.readyfo.yaclone.di.modules.AppModule

class App : Application() {
    companion object {
        lateinit var instance: App
        lateinit var context: Context
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        instance = this
        initDagger()
        RetrofitBuilder.createLanguagesService()
    }

    private fun initDagger(){
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        appComponent.injectApp(this)
    }
}