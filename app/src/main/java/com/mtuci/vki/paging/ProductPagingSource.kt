package com.mtuci.vki.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mtuci.vki.api.ApiClient
import com.mtuci.vki.api.ApiService
import com.mtuci.vki.model.ProductDTO
import kotlinx.coroutines.delay
import retrofit2.HttpException
import java.io.IOException

class ProductPagingSource : PagingSource<Int, ProductDTO>() {
    override fun getRefreshKey(state: PagingState<Int, ProductDTO>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(
                1
            )?:state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProductDTO> {
        val position = params.key ?: 1
        return try {
            delay(2000)
            val remoteDate = ApiClient.apiService.getProductList(position, params.loadSize)
            val nextKey = if (remoteDate.products.isEmpty()){
                null
            } else {
                position + 1
            }
            val prevKey = if (position == 1) null else position - 1
            LoadResult.Page(
                data = remoteDate.products,
                prevKey = prevKey,
                nextKey = nextKey
            )

        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}