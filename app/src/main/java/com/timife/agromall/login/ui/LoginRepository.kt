package com.timife.agromall.login.ui

import com.timife.agromall.Resource
import com.timife.agromall.UserPreferences
import com.timife.agromall.base.BaseRepository
//import com.timife.agromall.login.network.LoginApi


//class LoginRepository(
//    private val api: LoginApi,
//    private val preferences: UserPreferences
//) : BaseRepository() {
//
//    suspend fun login(
//        email: String,
//        password: String
//    ): Resource<LoginResponse> {
//        return safeApiCall {
//            api.login(email, password)
//        }
//    }
//
//    suspend fun saveAuthToken(token: String) {
//        preferences.saveAuthToken(token)
//    }
//}