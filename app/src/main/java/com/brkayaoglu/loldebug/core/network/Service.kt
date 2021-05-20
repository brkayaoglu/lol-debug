package com.brkayaoglu.loldebug.core.network

import com.brkayaoglu.loldebug.model.ResponseStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

interface Service {
    suspend fun <T> request(
        apiCall: suspend () -> T
    ): ResponseStatus<T> {
        return withContext(Dispatchers.IO) {
            try {
                ResponseStatus.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                println(throwable)
                when (throwable) {
                    is HttpException -> {
                        ResponseStatus.Error(false, throwable.code(), throwable.response()?.errorBody())
                    }
                    else -> {
                        ResponseStatus.Error(true, null, null)
                    }
                }
            }
        }
    }
}