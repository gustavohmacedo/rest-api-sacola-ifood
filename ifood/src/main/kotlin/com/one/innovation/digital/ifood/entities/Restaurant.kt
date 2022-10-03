package com.one.innovation.digital.ifood.entities

data class Restaurant(
    val restaurantId: Long,
    val name: String,
    val cnpj: String,
    val menu: MutableList<Product>,
    val address: Address
)
