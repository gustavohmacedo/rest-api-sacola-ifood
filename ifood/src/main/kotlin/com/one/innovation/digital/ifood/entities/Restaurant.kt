package com.one.innovation.digital.ifood.entities

import javax.persistence.*

@Entity
@Table(name = "TB_RESTAURANT")
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
