package com.mtuci.vki.main

import androidx.lifecycle.ViewModel
import com.mtuci.vki.R
import com.mtuci.vki.main.item.GoodItem

class MainViewModel : ViewModel() {
    val goods = listOf(
        GoodItem(
            id = 1,
            title = "iPhone 9",
            description = "An apple mobile which is nothing like apple",
            thumbnail = R.drawable.default_image,
            price = 549,
            stock = 94,
            rating = 4.69
        ),
        GoodItem(
            id = 2,
            title = "iPhone X",
            description = "SIM-Free, Model A19211 6.5-inch Super Retina HD display with OLED technology A12 Bionic chip with ...",
            thumbnail = R.drawable.default_image,
            price = 899,
            stock = 34,
            rating = 4.44
        )
    )

}