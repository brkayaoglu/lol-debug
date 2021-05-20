package com.brkayaoglu.loldebug.model

import okhttp3.ResponseBody

sealed class ResponseStatus<out T> {
    data class Success<out T>(val value: T) : ResponseStatus<T>()
    data class Error(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ) : ResponseStatus<Nothing>()
    object Loading : ResponseStatus<Nothing>()
}