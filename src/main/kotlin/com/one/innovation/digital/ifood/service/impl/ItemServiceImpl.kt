package com.one.innovation.digital.ifood.service.impl

import com.one.innovation.digital.ifood.entity.Item
import com.one.innovation.digital.ifood.exception.ItemNotFoundException
import com.one.innovation.digital.ifood.repository.ItemRepository
import com.one.innovation.digital.ifood.service.ItemService
import org.springframework.stereotype.Service

@Service
class ItemServiceImpl(
    private val itemRepository: ItemRepository
) : ItemService {

    override fun findItemById(itemId: Long): Item {
        val itemOptional = itemRepository.findById(itemId)
        if (itemOptional.isEmpty) {
            throw ItemNotFoundException("Item not found")
        }

        return itemOptional.get()

    }

}