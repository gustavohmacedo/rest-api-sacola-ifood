package com.one.innovation.digital.ifood.entity

import javax.persistence.Embeddable

@Embeddable
data class Address(
    val cep: String,
    val complement: String
)
