package com.readyfo.yaclone

import android.app.Application
import android.content.Context
import com.readyfo.yaclone.datasource.local.db.YacloneDataBase
import com.readyfo.yaclone.datasource.remote.RetrofitBuilder
import com.readyfo.yaclone.di.AppComponent
import com.readyfo.yaclone.di.DaggerAppComponent

class App : Application() {
    companion object {
        lateinit var instance: App
        lateinit var yacloneDB: YacloneDataBase
        lateinit var context: Context
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        instance = this
        yacloneDB = YacloneDataBase.getInstance(context = this)
        initDagger()
        RetrofitBuilder.createLanguagesService()
    }

    private fun initDagger(){
        appComponent = DaggerAppComponent.create()
    }
}