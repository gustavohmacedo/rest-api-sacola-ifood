package com.one.innovation.digital.ifood.entities

import javax.persistence.Embeddable

@Embeddable
data class Address(
    val cep: String,
    val complement: String
)
