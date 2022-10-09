package com.one.innovation.digital.ifood.repositories

import com.one.innovation.digital.ifood.entities.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<Item, Long>