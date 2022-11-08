package com.one.innovation.digital.ifood.entity

import javax.persistence.*

@Entity
@Table(name = "tb_restaurant")
data class Restaurant(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val restaurantId: Long? = null,
    val name: String,
    val cnpj: String,
    @OneToMany(cascade = [CascadeType.ALL])
    val menu: MutableList<Product>? = mutableListOf(),
    @Embedded
    val address: Address
)
