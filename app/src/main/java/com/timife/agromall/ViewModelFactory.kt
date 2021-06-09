package com.timife.agromall

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.timife.agromall.base.BaseRepository
import com.timife.agromall.login.ui.LoginViewModel


@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: BaseRepository? = null,
    private val userPreferences: UserPreferences? = null
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) ->
                LoginViewModel(userPreferences as UserPreferences) as T
            else -> throw  IllegalArgumentException("ViewModelClass not found")
        }
    }
}