package com.one.innovation.digital.ifood.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "tb_bag")
data class Bag(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val bagId: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    val client: Client,
    @OneToMany(cascade = [CascadeType.ALL])
    val bagItems: MutableList<Item>? = mutableListOf(),
    val bagTotalAmount: Double,
    @Enumerated(EnumType.STRING)
    val paymentType: PaymentType,
    val isClosedBag: Boolean?
)