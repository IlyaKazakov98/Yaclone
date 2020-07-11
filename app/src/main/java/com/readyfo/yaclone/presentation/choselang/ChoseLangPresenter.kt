package com.readyfo.yaclone.presentation.choselang

import android.util.Log
import com.readyfo.yaclone.domain.usecases.FetchLanguagesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import moxy.MvpPresenter

class ChoseLangPresenter(private val fetchLanguagesUseCase: FetchLanguagesUseCase) :
    MvpPresenter<ChoseLangView>() {

    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    fun fetchLanguages() {
        isLoading(true)

        val disposable = fetchLanguagesUseCase.fetchLanguages()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    isLoading(false)
                    viewState.presentLanguages(it)
                },
                {
                    isLoading(false)
                    Log.d("Lang", "From Presenter: ${it.message}")
                }
            )
        compositeDisposable.add(disposable)
    }

    private fun isLoading(bool: Boolean) {
        viewState.presentLoading(bool)
    }
}