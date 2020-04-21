package com.readyfo.yaclone.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.readyfo.yaclone.datasource.local.entity.LanguageEntity
import io.reactivex.Observable

@Dao
interface ChoseLanguageDAO {
    @Query("SELECT * FROM languages_table")
    fun fetchLanguages(): Observable<List<LanguageEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveLanguages(languages: List<LanguageEntity>)
}