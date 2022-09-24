package com.example.wishlist

data class WishItem (
        val item_name: String,
        val item_price: Double,
        val item_url: String,
        var isBought: Boolean)