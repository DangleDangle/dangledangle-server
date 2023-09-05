package com.dangle.adapter.persistence.repository

import com.dangle.adapter.persistence.entity.ShelterBookMarkEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ShelterBookMarkJpaRepository : JpaRepository<ShelterBookMarkEntity, Long> {
    fun findByShelterIdAndVolunteerId(shelterId: Long, volunteerId: Long): ShelterBookMarkEntity?
}
