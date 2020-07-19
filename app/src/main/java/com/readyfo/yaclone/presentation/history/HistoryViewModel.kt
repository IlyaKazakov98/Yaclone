package com.readyfo.yaclone.presentation.history

import androidx.lifecycle.ViewModel
import com.readyfo.yaclone.domain.usecases.FetchHistoryUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class HistoryViewModel(private val fetchHistoryUseCase: FetchHistoryUseCase) :
    ViewModel() {
    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

//    override fun onDestroy() {
//        compositeDisposable.dispose()
//        super.onDestroy()
//    }

    fun fetchHistory() {
//        isLoading()
//
        val disposable = fetchHistoryUseCase.fetchHistory()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
//                if (it.isNotEmpty())
//                    viewState.presentHistory(it)
//                else
//                    viewState.presentHistoryEmpty(true)
            }, {
//
            })
        compositeDisposable.add(disposable)
    }

//    private fun isLoading() {
//        viewState.presentHistoryEmpty(false)
//    }
}