package com.one.innovation.digital.ifood.dto

import java.time.LocalDateTime

data class ApiError(
    val timestamp: LocalDateTime? = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String,
    val path: String
)
