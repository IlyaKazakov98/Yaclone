package com.readyfo.yaclone.core

sealed class Result<out R> {

    data class Success<out T>(val data: T? = null) : Result<T>()
    data class Error(val e: Exception) : Result<Nothing>()
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[message=${e.message}]"
            Loading -> "Loading"
        }
    }

    fun isDone() = this is Success || this is Error
}