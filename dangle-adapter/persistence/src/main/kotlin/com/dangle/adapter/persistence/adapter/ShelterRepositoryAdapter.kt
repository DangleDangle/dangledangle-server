package com.dangle.adapter.persistence.adapter

import com.dangle.adapter.persistence.adapter.mapper.ShelterMapper
import com.dangle.adapter.persistence.entity.ShelterBookMarkEntity
import com.dangle.adapter.persistence.repository.ShelterBookMarkJpaRepository
import com.dangle.adapter.persistence.repository.ShelterJpaRepository
import com.dangle.common.DangleErrorCode
import com.dangle.common.DangleException
import com.dangle.domain.shelter.Shelter
import com.dangle.domain.shelter.ShelterBookMark
import com.dangle.usecase.shelter.port.out.ShelterRepositoryPort
import jakarta.transaction.Transactional
import kotlin.jvm.optionals.getOrElse

open class ShelterRepositoryAdapter(
    private val shelterJpaRepository: ShelterJpaRepository,
    private val shelterBookMarkJpaRepository: ShelterBookMarkJpaRepository,
) : ShelterRepositoryPort {
    override fun findById(id: Long): Shelter {
        val shelterEntity = shelterJpaRepository.findById(id)
            .getOrElse { throw DangleException(DangleErrorCode.NOT_FOUND_SHELTER, "shelterId - $id") }
        return ShelterMapper.toDomain(shelterEntity)
    }

    override fun findBookMark(shelterId: Long, volunteerId: Long): ShelterBookMark {
        return shelterBookMarkJpaRepository.findByShelterIdAndVolunteerId(shelterId, volunteerId)
            ?.let { ShelterBookMark(shelterId, volunteerId, true) }
            ?: ShelterBookMark(shelterId, volunteerId, false)
    }

    @Transactional
    override fun saveBookMark(shelterBookMark: ShelterBookMark): ShelterBookMark {
        val (shelterId, volunteerId, isBookMarked) = shelterBookMark
        return if (isBookMarked) {
            shelterBookMarkJpaRepository.save(ShelterBookMarkEntity(0, shelterId, volunteerId))
            ShelterBookMark(shelterId, volunteerId, true)
        } else {
            shelterBookMarkJpaRepository.findByShelterIdAndVolunteerId(shelterId, volunteerId)?.let {
                shelterBookMarkJpaRepository.delete(it)
            }
            ShelterBookMark(shelterId, volunteerId, false)
        }
    }
}
