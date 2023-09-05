package com.dangle.adapter.persistence.common

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Address(
    @Column(name = "address")
    val address: String,
    @Column(name = "address_detail")
    val addressDetail: String,
    @Column(name = "postal_code", nullable = false)
    val postalCode: String,
    @Column(name = "latitude", nullable = false)
    val latitude: Double,
    @Column(name = "longitude", nullable = false)
    val longitude: Double,
) {
    fun toDomain(): com.dangle.domain.common.vo.Address {
        return com.dangle.domain.common.vo.Address(
            address = this.address,
            addressDetail = this.addressDetail,
            postalCode = this.postalCode,
            latitude = this.latitude,
            longitude = this.longitude,
        )
    }
}
