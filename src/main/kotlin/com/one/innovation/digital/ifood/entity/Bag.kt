package com.one.innovation.digital.ifood.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.one.innovation.digital.ifood.enumeration.PaymentType
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
    val items: MutableList<Item>? = mutableListOf(),
    var bagTotalAmount: Double,
    @Enumerated(EnumType.STRING)
    var paymentType: PaymentType,
    var isClosedBag: Boolean? = false
)