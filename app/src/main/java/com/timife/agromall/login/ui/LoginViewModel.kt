package com.timife.agromall.login.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.timife.agromall.Resource
import com.timife.agromall.base.BaseViewModel
import kotlinx.coroutines.launch

//class LoginViewModel(private val repository: LoginRepository) : BaseViewModel(repository) {
//    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
//    val loginResponse: LiveData<Resource<LoginResponse>>
//        get() = _loginResponse
//
//    fun loginUser(
//        password: String,
//        email: String
//    ) {
//        viewModelScope.launch {
//            _loginResponse.value = Resource.Loading
//            _loginResponse.value = repository.login(email, password)
//        }
//    }
//
//    suspend fun saveAuthToken(token: String)  {
//        repository.saveAuthToken(token)
//    }
//}