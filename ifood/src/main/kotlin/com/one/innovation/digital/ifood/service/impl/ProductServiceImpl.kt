package com.one.innovation.digital.ifood.service.impl

import com.one.innovation.digital.ifood.entity.Product
import com.one.innovation.digital.ifood.exception.ApplicationException
import com.one.innovation.digital.ifood.exception.ProductNotFoundException
import com.one.innovation.digital.ifood.repository.ProductRepository
import com.one.innovation.digital.ifood.service.ProductService
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository,
) : ProductService {

    override fun findProductById(id: Long): Product {
        val productOptional = productRepository.findById(id)
        if (productOptional.isEmpty) {
            throw ProductNotFoundException("Product not found")
        }
        return productOptional.get()
    }
}