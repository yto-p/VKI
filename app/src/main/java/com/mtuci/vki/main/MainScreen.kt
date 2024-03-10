package com.mtuci.vki.main

import androidx.compose.runtime.Composable

@Composable
fun MainScreen(){
    val viewModel = MainViewModel()
    val goods = viewModel.goods

    MainContent(goods)
}