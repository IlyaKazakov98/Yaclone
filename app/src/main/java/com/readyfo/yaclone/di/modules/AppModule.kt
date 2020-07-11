package com.readyfo.yaclone.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(val app: Application) {

    @Provides
    @Singleton
    fun providesApplication() = app

//    @Provides
//    @Singleton
//    fun providesApplicationContext(app: Application): Context = app.applicationContext

//    @Provides
//    @Singleton
//    @Named("app")
//    fun providesApplication(): Application {
//        return mApplication
//    }
//
//    @Singleton
//    @Provides
//    @Named("appContext")
//    fun provideContext(): Context {
//        return mApplication.applicationContext
//    }
}