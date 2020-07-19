package com.readyfo.yaclone.presentation.choselang

import android.util.Log
import androidx.lifecycle.ViewModel
import com.readyfo.yaclone.domain.usecases.FetchLanguagesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ChoseLangViewModel(private val fetchLanguagesUseCase: FetchLanguagesUseCase) :
    ViewModel() {

    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    fun fetchLanguages() {
//        isLoading(true)
//
        val disposable = fetchLanguagesUseCase.fetchLanguages()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
//                    isLoading(false)
//                    viewState.presentLanguages(it)
                },
                {
//                    isLoading(false)
                    Log.d("Lang", "From Presenter: ${it.message}")
                }
            )
        compositeDisposable.add(disposable)
    }

//    private fun isLoading(bool: Boolean) {
//        viewState.presentLoading(bool)
//    }
}