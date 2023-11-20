package com.one.innovation.digital.ifood.dto

import com.one.innovation.digital.ifood.entity.Item
import com.one.innovation.digital.ifood.entity.Product

data class ItemResponseDTO(
    val itemId: Long?,
    val product: Product,
    val amount: Int,
)

fun Item.toItemResponseDTO() = ItemResponseDTO(
    itemId = this.itemId,
    product = this.product,
    amount = this.amount,
)
