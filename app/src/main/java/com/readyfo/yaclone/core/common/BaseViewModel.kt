package com.readyfo.yaclone.core.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.readyfo.yaclone.core.Result
import com.readyfo.yaclone.core.events.ErrorEvent

abstract class BaseViewModel : ViewModel() {

    private val _error = MutableLiveData<ErrorEvent>()

    private val _isLoading = MutableLiveData<Boolean>()

    val error: LiveData<ErrorEvent> = _error

    val isLoading: LiveData<Boolean> = _isLoading

    fun setError(e: ErrorEvent) {
        _error.postValue(e)
    }

    fun clearError() {
        _error.postValue(null)
    }

    fun startLoading() {
        _isLoading.postValue(true)
    }

    fun stopLoading() {
        _isLoading.postValue(false)
    }

    fun <R> handleResult(
        r: Result<R>,
        doOnSuccess: ((r: Result.Success<R>) -> Unit)? = null
    ) {
        _handleResult(r, doOnSuccess)
    }

    fun <R> handleResultAndError(
        r: Result<R>,
        doOnSuccess: (r: Result.Success<R>) -> Unit,
        doOnError: (e: Exception) -> Unit
    ) {
        _handleResult(r, doOnSuccess, doOnError)
    }

    private fun <R> _handleResult(
        r: Result<R>,
        doOnSuccess: ((r: Result.Success<R>) -> Unit)? = null,
        doOnError: ((e: Exception) -> Unit)? = null
    ) {
        when (r) {
            is Result.Loading -> {
                startLoading()
                clearError()
            }
            is Result.Success -> {
                stopLoading()
                doOnSuccess?.invoke(r)
            }
            is Result.Error -> {
                stopLoading()

                if (doOnError == null) setError(ErrorEvent(r.e))
                else doOnError(r.e)
            }
        }
    }
}