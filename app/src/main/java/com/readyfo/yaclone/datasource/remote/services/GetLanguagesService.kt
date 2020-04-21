package com.readyfo.yaclone.datasource.remote.services

import com.readyfo.yaclone.datasource.remote.models.LanguagesDTO
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GetLanguagesService {
    @GET("/api/v1.5/tr.json/getLangs")
    fun getLanguages(@Query("ui") ui: String, @Query("key") key: String): Observable<LanguagesDTO>
}