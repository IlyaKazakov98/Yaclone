package com.readyfo.yaclone.presentation.choselang

import com.readyfo.yaclone.domain.models.LanguageModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ChoseLangView : MvpView {
    fun presentLanguages(languages: List<LanguageModel>)
    fun presentLoading(isLoading: Boolean)
//    fun presentHistoryEmpty(isEmpty: Boolean)
}