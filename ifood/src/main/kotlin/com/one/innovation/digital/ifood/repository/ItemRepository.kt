package com.one.innovation.digital.ifood.repository

import com.one.innovation.digital.ifood.entity.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<Item, Long>