package com.mtuci.vki.main.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GoodItemView(item: GoodItem){
    Column(
        modifier = Modifier
            .padding(vertical = 2.dp)
            .clickable { }

    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 25.dp)
        ) {
            Image(
                painter = painterResource(id = item.thumbnail),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(70.dp)
                    .width(100.dp)
                    .clip(RoundedCornerShape(5.dp))
            )
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 15.dp)
            ) {
                Text(
                    text = item.price.toString() + "$",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 1.dp)
                )
                Text(
                    text = item.title,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = item.description,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 13.sp,
                    lineHeight = 20.sp
                )
                Text(
                    text = "Stock: " + item.stock,
                    fontSize = 13.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(2.dp))
                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        painter = rememberVectorPainter(image = Icons.Filled.Star),
                        contentDescription = "",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = item.rating.toString(),
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}