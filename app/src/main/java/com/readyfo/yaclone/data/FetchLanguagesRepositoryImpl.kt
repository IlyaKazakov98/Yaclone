package com.readyfo.yaclone.data

import com.readyfo.yaclone.data.datasource.local.FetchLanguagesLocalDataSource
import com.readyfo.yaclone.data.datasource.local.SaveLanguagesInDataSource
import com.readyfo.yaclone.data.datasource.remote.FetchLanguagesRemoteDataSource
import com.readyfo.yaclone.domain.models.LanguageModel
import com.readyfo.yaclone.domain.repositories.FetchLanguagesRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class FetchLanguagesRepositoryImpl @Inject constructor(
    private val fetchLanguagesLocalDataSource: FetchLanguagesLocalDataSource,
    private val fetchLanguagesRemoteDataSource: FetchLanguagesRemoteDataSource,
    private val saveLanguagesInDataSource: SaveLanguagesInDataSource
) : FetchLanguagesRepository {
    private val fetchLanguagesFromLocal by lazy {
        fetchLanguagesLocalDataSource.fetchLanguagesFromLocal()
    }
    private val fetchLanguagesFromRemote by lazy {
        fetchLanguagesRemoteDataSource.fetchLanguagesFromRemote()
    }

    override fun fetchLanguages(): Single<List<LanguageModel>> {

        return Observable
            .concat(
                fetchLanguagesFromLocal,
                fetchLanguagesFromRemote
                    .doOnNext {
                        saveLanguagesInDataSource.saveLanguagesInDataBase(it)
                    }
            )
            .filter { it.isNotEmpty() }
            .first(listOf(LanguageModel(key = "isEmpty", language = "isEmpty")))
    }
}