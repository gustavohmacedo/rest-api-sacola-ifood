package com.one.innovation.digital.ifood.service

import com.one.innovation.digital.ifood.dto.BagResponseDTO
import com.one.innovation.digital.ifood.dto.CloseBagResponseDTO
import com.one.innovation.digital.ifood.dto.ItemRequestDTO
import com.one.innovation.digital.ifood.dto.ItemResponseDTO

interface BagService {
    fun addItem(itemRequestDTO: ItemRequestDTO): ItemResponseDTO
    fun findBagById(bagId: Long): BagResponseDTO
    fun closeBagById(bagId: Long, paymentType: String): CloseBagResponseDTO
    fun removeProductFromBag(itemRequestDTO: ItemRequestDTO): BagResponseDTO
}