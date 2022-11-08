package com.one.innovation.digital.ifood.service

import com.one.innovation.digital.ifood.entity.Product

interface ProductService {
    fun findProductById(id: Long): Product
}