package com.dangle.adapter.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Index
import jakarta.persistence.Table

@Entity
@Table(
    name = "shelter_bookmark",
    indexes = [
        Index(name = "IDX_SHELTER_BOOKMARK", columnList = "shelter_id,volunteer_id")
    ]
)
class ShelterBookMarkEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "shelter_id", nullable = false)
    val shelterId: Long,

    @Column(name = "volunteer_id", nullable = false)
    val volunteerId: Long
)
