package com.dangle.domain.common.vo

data class Address(
    val address: String,
    val addressDetail: String,
    val postalCode: String,
    val latitude: Double,
    val longitude: Double,
)
