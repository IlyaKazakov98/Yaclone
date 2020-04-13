package com.readyfo.yaclone.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.readyfo.yaclone.data.local.dao.HistoryDAO
import com.readyfo.yaclone.data.local.entity.HistoryEntity

@Database(
    entities = [HistoryEntity::class],
    exportSchema = false,
    version = 1
)

abstract class YacloneDataBase: RoomDatabase() {

    abstract fun getHistoryDao(): HistoryDAO

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