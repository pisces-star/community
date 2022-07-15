package com.oppo.community.core.common.network

import androidx.lifecycle.MutableLiveData
import com.oppo.community.core.common.base.BaseResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*


sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Throwable) : Result<Nothing>()
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}


val Result<*>.succeeded
    get() = this is Result.Success && data != null

fun <T> Result<T>.successOr(fallback: T): T {
    return (this as? Result.Success<T>)?.data ?: fallback
}

val <T> Result<T>.data: T?
    get() = (this as? Result.Success)?.data


inline fun <reified T> Result<T>.updateOnSuccess(liveData: MutableLiveData<T>) {
    if (this is Result.Success) {
        liveData.value = data
    }
}


inline fun <reified T> Result<T>.updateOnSuccess(stateFlow: MutableStateFlow<T>) {
    if (this is Result.Success) {
        stateFlow.value = data
    }
}

fun <T> Flow<BaseResponse<T>>.asResult(coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO): Flow<Result<T>> {
    return this
        .map {
            if (it.succeeded) Result.Success(it.data) else Result.Error(Exception(it.msg))
        }
        .onStart { emit(Result.Loading) }
        .catch { emit(Result.Error(it)) }
        .flowOn(coroutineDispatcher)
}
