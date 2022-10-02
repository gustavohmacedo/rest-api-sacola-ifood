package com.one.innovation.digital.ifood.entities

data class Bag(
    val bagId: Long,
    val client: Client,
    val bagItems: MutableList<Item>,
    val bagTotalAmount: Double,
    val paymentType: PaymentType,
    val isClosedBag: Boolean
)