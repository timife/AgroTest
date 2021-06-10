package com.timife.agromall

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.timife.agromall.base.BaseRepository
import com.timife.agromall.farmers.FarmersRepository
import com.timife.agromall.farmers.FarmersViewModel
import com.timife.agromall.login.ui.LoginViewModel
import com.timife.agromall.response.Farmer


@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: BaseRepository? = null,
    private val userPreferences: UserPreferences? = null
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) ->
                LoginViewModel(userPreferences as UserPreferences) as T
            modelClass.isAssignableFrom(FarmersViewModel::class.java) ->
                FarmersViewModel(repository as FarmersRepository) as T
            else -> throw  IllegalArgumentException("ViewModelClass not found")
        }
    }
}