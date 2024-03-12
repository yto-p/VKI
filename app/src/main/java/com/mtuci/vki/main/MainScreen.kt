package com.mtuci.vki.main

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.mtuci.vki.viewmodel.ProductViewModel

@Composable
fun MainScreen(){
    val viewModel: ProductViewModel = viewModel()
    val pagingData = viewModel.products.collectAsLazyPagingItems()

    MainContent(pagingData)
}