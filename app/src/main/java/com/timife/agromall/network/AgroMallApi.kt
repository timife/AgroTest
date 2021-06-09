package com.timife.agromall.network

import com.timife.agromall.response.FarmersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AgroMallApi {
    @GET("/farmer/sample")
    suspend fun getFarmers(
        @Query("limit")
        limit: String? = "n",
        @Query("page")
        pageNumber: Int?
    ): FarmersResponse
}