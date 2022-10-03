package com.one.innovation.digital.ifood.entities

data class Item(
    val itemId: Long,
    val product: Product,
    val amount: Int,
    val bag: Bag
)
