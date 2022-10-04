package com.one.innovation.digital.ifood.entities

import javax.persistence.*

@Entity
@Table(name = "TB_ITEM")
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val itemId: Long? = null,
    @OneToOne
    val product: Product,
    val amount: Int,
    @ManyToOne
    val bag: Bag
)
