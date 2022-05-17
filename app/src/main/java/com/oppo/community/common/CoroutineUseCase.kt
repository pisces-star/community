package com.oppo.community.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber


abstract class UseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO) {

    suspend operator fun invoke(parameters: P): Result<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters).let {
                    Result.Success(it)
                }
            }
        } catch (e: Exception) {
            Timber.d(e)
            Result.Error(e)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R
}
