package com.timife.agromall.base

import android.util.Log
import androidx.lifecycle.ViewModel


abstract class BaseViewModel(
    private val baseRepository: BaseRepository
) : ViewModel() {
    init{
        Log.d("VIEW_MODEL_TEST","View-model Created")
    }
//    suspend fun logout(api: UserApi) = baseRepository.logout(api)
}