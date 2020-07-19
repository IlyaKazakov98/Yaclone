package com.readyfo.yaclone.presentation.history

import com.readyfo.yaclone.core.common.BaseViewModel
import com.readyfo.yaclone.domain.usecases.FetchHistoryUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class HistoryViewModel(
    private val fetchHistoryUseCase: FetchHistoryUseCase
) : BaseViewModel() {

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
    }
}