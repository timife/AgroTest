package com.timife.agromall.farmers

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.timife.agromall.base.BaseRepository
import com.timife.agromall.network.AgroMallApi

class FarmersRepository(private val api: AgroMallApi): BaseRepository() {

    companion object {
        private const val NETWORK_PAGE_SIZE = 29
    }

    fun getFarmers( limit: String = "n") =
        Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                maxSize = 350,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                FarmersPagingSource(api, limit)
            }
        ).liveData
}