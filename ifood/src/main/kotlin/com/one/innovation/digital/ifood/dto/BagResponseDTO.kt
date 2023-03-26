package com.one.innovation.digital.ifood.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import com.one.innovation.digital.ifood.entity.Bag
import com.one.innovation.digital.ifood.entity.Client
import com.one.innovation.digital.ifood.entity.Item
import com.one.innovation.digital.ifood.enumeration.PaymentType

data class BagResponseDTO(
    val bagId: Long,
    @JsonIgnore
    val client: Client,
    val bagItems: MutableList<Item>,
    var bagTotalAmount: Double,
    var paymentType: PaymentType,
    var isClosedBag: Boolean?,
)

fun Bag.toBagResponseDTO() = BagResponseDTO(
    bagId = this.bagId!!,
    client = this.client,
    bagItems = this.items!!,
    bagTotalAmount = this.bagTotalAmount,
    paymentType = this.paymentType,
    isClosedBag = this.isClosedBag
)

fun BagResponseDTO.toBagEntity() = Bag(
    bagId = this.bagId,
    client = this.client,
    items = this.bagItems,
    bagTotalAmount = this.bagTotalAmount,
    paymentType = this.paymentType,
    isClosedBag = this.isClosedBag
)




