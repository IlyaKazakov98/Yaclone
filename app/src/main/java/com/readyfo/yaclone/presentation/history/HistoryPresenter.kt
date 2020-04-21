package com.readyfo.yaclone.presentation.history

import com.readyfo.yaclone.domain.usecases.FetchHistoryUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter


@InjectViewState
class HistoryPresenter(private val fetchHistoryUseCase: FetchHistoryUseCase) :
    MvpPresenter<HistoryView>() {
    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    fun fetchHistory() {
        isLoading()

        val disposable = fetchHistoryUseCase.fetchHistory()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.isNotEmpty())
                    viewState.presentHistory(it)
                else
                    viewState.presentHistoryEmpty(true)
            }, {

            })
        compositeDisposable.add(disposable)
    }

    private fun isLoading() {
        viewState.presentHistoryEmpty(false)
    }
}