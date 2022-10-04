package com.one.innovation.digital.ifood.entities

import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "TB_CLIENT")
data class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val clientId: Long? = null,
    val name: String,
    @Embedded
    val address: Address
)
