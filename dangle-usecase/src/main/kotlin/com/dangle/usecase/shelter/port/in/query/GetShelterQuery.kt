package com.dangle.usecase.shelter.port.`in`.query

import com.dangle.domain.shelter.Shelter
import com.dangle.usecase.shelter.port.out.ShelterRepositoryPort
import org.springframework.stereotype.Service

@Service
class GetShelterQuery(
    private val shelterRepositoryPort: ShelterRepositoryPort,
): GetShelterQueryUseCase {
    override fun invoke(shelterId: Long): Shelter {
        return shelterRepositoryPort.findById(shelterId)
    }
}
