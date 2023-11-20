package com.one.innovation.digital.ifood.repository

import com.one.innovation.digital.ifood.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>