package com.one.innovation.digital.ifood.dto

import com.one.innovation.digital.ifood.entity.Bag

data class CloseBagResponseDTO(
    val bagId: Long,
    val isClosed: Boolean
)

fun Bag.toCloseBagResponseDTO() = CloseBagResponseDTO(
    bagId = this.bagId!!,
    isClosed = this.isClosedBag!!
)
