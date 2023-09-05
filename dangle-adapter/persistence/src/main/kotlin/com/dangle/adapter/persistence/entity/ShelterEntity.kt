package com.dangle.adapter.persistence.entity

import com.dangle.adapter.persistence.common.Address
import com.dangle.adapter.persistence.common.BaseTimeEntity
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "shelter")
class ShelterEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(name = "name", nullable = false)
    val name: String,
    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    val description: String,
    @Column(nullable = false)
    @Embedded
    val address: Address,
    @Column(name = "phone_num", nullable = false)
    val phoneNum: String,
    @Column(name = "bank_name")
    val bankName: String?,
    @Column(name = "bank_account_num")
    val bankAccountNum: String?,
    @Column(name = "notice")
    val notice: String?,
    @Column(name = "is_parking_enabled")
    val parkingEnabled: Boolean?,
    @Column(name = "parking_notice")
    val parkingNotice: String?,
    @Column(name = "profile_image_url")
    val profileImageUrl: String?,
    @Column(name = "is_alarm_enabled", nullable = false)
    val alarmEnabled: Boolean = true
) : BaseTimeEntity()
