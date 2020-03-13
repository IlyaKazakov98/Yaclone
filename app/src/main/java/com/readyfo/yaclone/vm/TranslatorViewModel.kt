package com.readyfo.yaclone.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.readyfo.yaclone.vm.model.TransModel
import kotlinx.coroutines.launch

class TranslatorViewModel : ViewModel() {

    private val transLiveData: MutableLiveData<TransModel> = MutableLiveData()
    private val areTransLiveData: MutableLiveData<Boolean> = MutableLiveData()
    private val isErrorLiveData: MutableLiveData<Boolean> = MutableLiveData()
    private val isLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData()

    val trans: MutableLiveData<TransModel>
        get() = transLiveData

    val areEmptyTrans: MutableLiveData<Boolean>
        get() = areTransLiveData

    val isError: MutableLiveData<Boolean>
        get() = isErrorLiveData

    val isLoading: MutableLiveData<Boolean>
        get() = isLoadingLiveData

    init {
        handleTransLoad()
    }

    private fun handleTransLoad() {
        viewModelScope.launch {
            isLoadingLiveData(true)
//            updateAppropriateLiveData(
//                useCase.execute()
//            )
        }
    }

    private fun updateAppropriateLiveData(result: Result<TransModel>) {
//        if (isResultSuccess(result)) {
//            onResultSuccess(result.data)
//        } else {
//            onResultError()
//        }

        isLoadingLiveData(false)
    }

//    private fun isResultSuccess(result: Result<TransModel>) =
//        result.resultType == ResultType.SUCCESS

    private fun onResultSuccess(transEntity: TransModel?) {
//        val beers = Mapper.mapFrom(transEntity)
//
//        if (beers.isEmpty()) {
//            areTransLiveData.postValue(true)
//        } else {
//            transLiveData.postValue(beers)
//        }
    }

    private fun onResultError() {
        isErrorLiveData.postValue(true)
    }

    private fun isLoadingLiveData(isLoading: Boolean) {
        this.isLoadingLiveData.postValue(isLoading)
    }
}