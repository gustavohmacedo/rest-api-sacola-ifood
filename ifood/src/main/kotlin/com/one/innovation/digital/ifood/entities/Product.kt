package com.one.innovation.digital.ifood.entities

class Product(
    val productId: Long,
    val name: String,
    val productValue: Double,
    val isAvailable: Boolean,
    val restaurant: Restaurant
)
