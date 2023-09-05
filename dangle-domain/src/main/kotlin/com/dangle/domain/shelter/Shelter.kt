package com.dangle.domain.shelter

import com.dangle.domain.common.vo.Address
import com.dangle.domain.common.vo.BankAccount

data class Shelter(
    val id: Long = 0,
    val name: String,
    val description: String,
    val phoneNumber: String,
    val address: Address,
    val notice: String? = null,
    val profileImageUrl: String? = null,
    val bankAccount: BankAccount? = null,
    val parkingInfo: ShelterParkingInfo? = null,
    val alarmEnabled: Boolean = true
)
