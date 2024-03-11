package com.mtuci.vki.main

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.paging.compose.collectAsLazyPagingItems
import com.mtuci.vki.MainActivity
import com.mtuci.vki.viewmodel.ProductViewModel

@Composable
fun MainScreen(){
    val activity = LocalContext.current as MainActivity

    val viewModel: ProductViewModel by activity.viewModels()
    val pagingData = viewModel.products.collectAsLazyPagingItems()

    MainContent(pagingData)
}