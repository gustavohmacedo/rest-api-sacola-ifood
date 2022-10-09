package com.one.innovation.digital.ifood.repositories

import com.one.innovation.digital.ifood.entities.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>