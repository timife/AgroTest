package com.timife.agromall.farmers

import androidx.paging.PagingSource
import com.timife.agromall.network.AgroMallApi
import com.timife.agromall.response.Farmer
import retrofit2.HttpException
import java.io.IOException

private const val FARMERS_STARTING_PAGE_INDEX = 1

class FarmersPagingSource(
    private val agroMallApi: AgroMallApi,
    private val limit: String = "n"
) : PagingSource<Int, Farmer>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Farmer> {
        val pageNumber = params.key ?: FARMERS_STARTING_PAGE_INDEX

        return try {
            val response = agroMallApi.getFarmers(limit, pageNumber)
            val farmers = response.data.farmers

            LoadResult.Page(
                data = farmers,
                prevKey = if (pageNumber == FARMERS_STARTING_PAGE_INDEX) null else pageNumber - 1,
                nextKey = if (farmers.isEmpty()) null else pageNumber + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {

            if (
                exception.code() == 404
            ) {
                return LoadResult.Page(emptyList(), pageNumber - 1, null)

            }
            LoadResult.Error(exception)
        }
    }
}