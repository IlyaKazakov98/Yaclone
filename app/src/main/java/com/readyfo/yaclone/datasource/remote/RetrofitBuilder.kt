package com.readyfo.yaclone.datasource.remote

import com.google.gson.GsonBuilder
import com.readyfo.yaclone.datasource.remote.services.GetLanguagesService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {
    private const val BASE_URL = "https://translate.yandex.net"
    private const val CONNECTION_TIMEOUT_IN_SECONDS = 60L

    private val retrofit by lazy { buildRetrofit() }
    lateinit var getLanguagesService: GetLanguagesService

    fun createLanguagesService(){
        getLanguagesService = retrofit.create(GetLanguagesService::class.java)
    }

    private fun buildRetrofit() =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(buildHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(buildJsonConverter())
            .build()

    private fun buildHttpClient() =
        OkHttpClient.Builder()
            .readTimeout(CONNECTION_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(CONNECTION_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .addInterceptor(buildHttpLoginInterceptor())
            .addInterceptor(buildRequestInterceptor())
            .build()

    private fun buildJsonConverter() =
        GsonBuilder()
            .setPrettyPrinting()
            .create()
            .let {
                GsonConverterFactory.create(it)
            }

    private fun buildHttpLoginInterceptor() =
        HttpLoggingInterceptor()
            .apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

    private fun buildRequestInterceptor() =
        Interceptor { chain ->
            val originalRequest = chain.request()
            val request = originalRequest.newBuilder()
                .header("Accept", "application/json")
                .build()
            chain.proceed(request)
        }
}