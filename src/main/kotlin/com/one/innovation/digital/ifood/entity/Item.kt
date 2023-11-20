package com.one.innovation.digital.ifood.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "tb_item")
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val itemId: Long? = null,
    @OneToOne
    val product: Product,
    val amount: Int,
    @ManyToOne
    @JsonIgnore
    val bag: Bag
)
