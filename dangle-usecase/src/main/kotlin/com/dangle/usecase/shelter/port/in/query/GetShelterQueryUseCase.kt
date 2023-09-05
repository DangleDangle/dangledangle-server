package com.dangle.usecase.shelter.port.`in`.query

import com.dangle.domain.shelter.Shelter

interface GetShelterQueryUseCase {
    fun invoke(shelterId: Long): Shelter
}
