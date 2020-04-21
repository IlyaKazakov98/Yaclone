package com.readyfo.yaclone.datasource.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.readyfo.yaclone.datasource.local.dao.ChoseLanguageDAO
import com.readyfo.yaclone.datasource.local.dao.HistoryDAO
import com.readyfo.yaclone.datasource.local.entity.HistoryEntity
import com.readyfo.yaclone.datasource.local.entity.LanguageEntity

@Database(
    entities = [HistoryEntity::class, LanguageEntity::class],
    exportSchema = false,
    version = 1
)

abstract class YacloneDataBase: RoomDatabase() {

    abstract fun getHistoryDao(): HistoryDAO
    abstract fun getLanguagesDao(): ChoseLanguageDAO

    companion object {
        @Volatile
        private var instance: YacloneDataBase? = null

        private const val DATABASE_NAME = "yaclone_database.db"

        fun getInstance(context: Context): YacloneDataBase {
            if (instance == null) {
                synchronized(YacloneDataBase::class) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            context,
                            YacloneDataBase::class.java,
                            DATABASE_NAME
                        )
//                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return instance!!
        }
    }
}