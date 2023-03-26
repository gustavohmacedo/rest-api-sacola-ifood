package com.one.innovation.digital.ifood.service

import com.one.innovation.digital.ifood.entity.Product

interface ProductService {
    fun findProductById(productId: Long): Product
}