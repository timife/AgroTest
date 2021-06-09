package com.timife.agromall.base

import com.bumptech.glide.load.engine.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): com.timife.agromall.Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                com.timife.agromall.Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        com.timife.agromall.Resource.Failure(false, throwable.code(), throwable.response()?.errorBody())
                    }
                    else -> {
                        com.timife.agromall.Resource.Failure(true, null, null)
                    }
                }
            }
        }
    }

}