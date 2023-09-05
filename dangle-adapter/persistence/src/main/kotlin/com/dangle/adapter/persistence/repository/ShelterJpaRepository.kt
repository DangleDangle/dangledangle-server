package com.dangle.adapter.persistence.repository

import com.dangle.adapter.persistence.entity.ShelterEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ShelterJpaRepository : JpaRepository<ShelterEntity, Long>
