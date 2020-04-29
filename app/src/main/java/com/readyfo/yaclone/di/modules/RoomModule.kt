package com.readyfo.yaclone.di.modules

import android.app.Application
import androidx.room.Room
import com.readyfo.yaclone.datasource.local.dao.HistoryDAO
import com.readyfo.yaclone.datasource.local.dao.LanguagesDAO
import com.readyfo.yaclone.datasource.local.db.YacloneDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [AppModule::class])
class RoomModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Application): YacloneDataBase {
        return Room.databaseBuilder(
            app,
            YacloneDataBase::class.java,
            YacloneDataBase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providePersonDao(db: YacloneDataBase): HistoryDAO {
        return db.getHistoryDao()
    }


    @Provides
    @Singleton
    fun provideProjectDao(db: YacloneDataBase): LanguagesDAO {
        return db.getLanguagesDao()
    }
}