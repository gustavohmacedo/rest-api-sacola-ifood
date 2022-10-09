package com.one.innovation.digital.ifood.repositories

import com.one.innovation.digital.ifood.entities.Bag
import org.springframework.data.jpa.repository.JpaRepository

interface BagRepository : JpaRepository<Bag, Long>
