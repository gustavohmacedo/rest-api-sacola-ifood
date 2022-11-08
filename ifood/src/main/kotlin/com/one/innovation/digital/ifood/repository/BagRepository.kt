package com.one.innovation.digital.ifood.repository

import com.one.innovation.digital.ifood.entity.Bag
import org.springframework.data.jpa.repository.JpaRepository

interface BagRepository : JpaRepository<Bag, Long>
