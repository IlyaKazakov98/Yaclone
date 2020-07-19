package com.readyfo.yaclone.di.modules

import androidx.room.Room
import com.readyfo.yaclone.datasource.local.db.YacloneDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            YacloneDataBase::class.java,
            YacloneDataBase.DATABASE_NAME
        ).build()
    }

    single { get<YacloneDataBase>().getHistoryDao() }
    single { get<YacloneDataBase>().getLanguagesDao() }
}