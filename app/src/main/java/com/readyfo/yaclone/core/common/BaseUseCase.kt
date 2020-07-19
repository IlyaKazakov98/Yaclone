package com.readyfo.yaclone.core.common

import com.readyfo.yaclone.core.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent

abstract class BaseUseCase(
    private val coroutineDispatcher: CoroutineDispatcher? = null
) : KoinComponent {

    protected suspend fun <R> runInCoroutine(block: suspend () -> R): Result<R> {
        return try {
            if (coroutineDispatcher != null) {
                withContext(coroutineDispatcher) {
                    Result.Success(block())
                }
            } else {
                Result.Success(block())
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    protected fun <R> runInFlow(block: () -> Flow<Result<R>>): Flow<Result<R>> =
        block()
            .catch { e -> emit(Result.Error(Exception(e))) }
            .apply {
                if (coroutineDispatcher != null) {
                    flowOn(coroutineDispatcher)
                }
            }
}