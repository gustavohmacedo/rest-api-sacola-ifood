package com.one.innovation.digital.ifood.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "tb_product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val productId: Long? = null,
    val name: String,
    val productValue: Double,
    val isAvailable: Boolean = true,
    @ManyToOne
    @JsonIgnore
    val restaurant: Restaurant
)
