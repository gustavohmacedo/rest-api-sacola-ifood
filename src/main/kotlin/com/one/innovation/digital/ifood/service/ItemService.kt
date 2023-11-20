package com.one.innovation.digital.ifood.service

import com.one.innovation.digital.ifood.entity.Item

interface ItemService {

    fun findItemById(itemId: Long): Item
}