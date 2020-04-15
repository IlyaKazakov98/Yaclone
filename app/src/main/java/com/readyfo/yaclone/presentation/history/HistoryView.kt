package com.readyfo.yaclone.presentation.history

import com.readyfo.yaclone.domain.models.HistoryModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface HistoryView : MvpView {
    fun presentHistory(historyData: MutableList<HistoryModel>)
    fun presentLoading(isLoading: Boolean)
    fun presentHistoryEmpty(isEmpty: Boolean)
}