package com.one.innovation.digital.ifood.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "TB_BAG")
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
    @Enumerated
    val paymentType: PaymentType,
    val isClosedBag: Boolean?
)