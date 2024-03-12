package com.mtuci.vki.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.mtuci.vki.R
import com.mtuci.vki.model.ProductDTO

@Composable
fun MainContent(
    pagingData: LazyPagingItems<ProductDTO>
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.products),
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        }
        Column(
            modifier = Modifier.fillMaxSize()
        ){
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
            ){
                if (pagingData.loadState.refresh is LoadState.Loading){
                    item {
                        Box(modifier = Modifier.fillParentMaxSize()){
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .align(Alignment.Center))
                        }
                    }
                }
                if (pagingData.loadState.refresh is LoadState.NotLoading){
                    items(pagingData){
                        it?.let {
                            ProductView(product = it)
                        }
                    }
                }
                if (pagingData.loadState.refresh is LoadState.Error){
                    item {
                        Box(modifier = Modifier.fillParentMaxSize()) {
                            Text(
                                text = "Retry",
                                fontStyle = FontStyle.Italic,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .clickable {
                                        pagingData.refresh()
                                    })
                        }
                    }
                }

                if (pagingData.loadState.append is LoadState.Loading){
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .padding(bottom = 10.dp)
                            )
                        }
                    }
                }
                if (pagingData.loadState.append is LoadState.Error){
                    item {
                        ErrorFooter { pagingData.retry() }
                    }
                }

                if (pagingData.loadState.prepend is LoadState.Loading){
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .padding(bottom = 10.dp)
                            )
                        }
                    }
                }
                if (pagingData.loadState.prepend is LoadState.Error){
                    item {
                        ErrorHeader { pagingData.retry() }
                    }
                }
            }
        }
    }
}

@Composable
fun ErrorHeader(retry: () -> Unit){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Text(
            text = "Click to Retry",
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { retry.invoke() }
        )
    }
}

 @Composable
fun ErrorFooter(retry: () -> Unit){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(8.dp)
        ) {
            Text(
                text = "Retry",
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .clickable { retry.invoke() }
            )
        }
    }
}