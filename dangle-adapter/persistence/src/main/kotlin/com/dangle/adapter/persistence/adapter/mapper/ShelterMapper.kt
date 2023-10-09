package com.dangle.adapter.persistence.adapter.mapper

import com.dangle.adapter.persistence.entity.ShelterBookMarkEntity
import com.dangle.adapter.persistence.entity.ShelterEntity
import com.dangle.domain.common.vo.BankAccount
import com.dangle.domain.shelter.Shelter
import com.dangle.domain.shelter.ShelterBookMark
import com.dangle.domain.shelter.ShelterParkingInfo

object ShelterMapper {
    fun toDomain(
        entity: ShelterEntity,
    ): Shelter {
        return Shelter(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            phoneNumber = entity.phoneNum,
            notice = entity.notice,
            profileImageUrl = entity.profileImageUrl,
            address = entity.address.toDomain(),
            bankAccount = runCatching {
                BankAccount(
                    name = entity.bankName!!,
                    accountNumber = entity.bankAccountNum!!,
                )
            }.getOrNull(),
            parkingInfo = runCatching {
                ShelterParkingInfo(
                    parkingEnabled = entity.parkingEnabled!!,
                    parkingNotice = entity.parkingNotice!!,
                )
            }.getOrNull(),
            alarmEnabled = entity.alarmEnabled,
        )
    }

    fun toDomain(
        entity: ShelterBookMarkEntity
    ): ShelterBookMark {
        return ShelterBookMark(
            shelterId = entity.shelterId,
            volunteerId = entity.volunteerId,
            bookMarked = true,
        )
    }
}
