package com.readyfo.yaclone.presentation.history

import com.readyfo.yaclone.domain.usecases.FetchHistoryUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter


@InjectViewState
class HistoryPresenter(val fetchHistoryUseCase: FetchHistoryUseCase) : MvpPresenter<HistoryView>() {
    private var compositeDisposable = CompositeDisposable()

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
                viewState.presentLoading(false)
                if (it.isNotEmpty())
                    viewState.presentHistory(it)
                else
                    viewState.presentHistoryEmpty(true)
            }, {
                viewState.presentLoading(false)
            })
        compositeDisposable.add(disposable)
    }

    private fun isLoading() {
        viewState.presentLoading(true)
        viewState.presentHistoryEmpty(false)
    }
}

//        val handler = Handler()
//        thread {
//            Thread.sleep(1000)
//
//            val mockHistory = ArrayList<HistoryModel>()
//            mockHistory.add(
//                HistoryModel(
//                    id = 0,
//                    textFrom = "Привет!",
//                    textTo = "Hello!",
//                    languageFrom = "ru",
//                    languageTo = "en",
//                    favorite = true
//                )
//            )
//            handler.post {
//                viewState.presentLoading(false)
//                if (mockHistory.isNotEmpty()) {
//                    viewState.presentHistory(mockHistory)
//                }
//                else
//                    viewState.presentHistoryEmpty(true)
//            }
//        }