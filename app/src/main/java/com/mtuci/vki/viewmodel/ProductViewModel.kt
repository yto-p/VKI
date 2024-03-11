package com.mtuci.vki.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mtuci.vki.model.ProductDTO
import com.mtuci.vki.paging.ProductPagingSource
import kotlinx.coroutines.flow.Flow

class ProductViewModel : ViewModel() {

    val products: Flow<PagingData<ProductDTO>> = Pager(PagingConfig(pageSize = 20)){
        ProductPagingSource()
    }.flow
}