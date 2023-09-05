package com.dangle.adapter.persistence.config

import com.dangle.adapter.persistence.adapter.ShelterRepositoryAdapter
import com.dangle.adapter.persistence.repository.ShelterBookMarkJpaRepository
import com.dangle.adapter.persistence.repository.ShelterJpaRepository
import com.dangle.usecase.shelter.port.out.ShelterRepositoryPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RepositoryAdapterConfig {
    @Bean
    fun shelterRepositoryPort(
        shelterJpaRepository: ShelterJpaRepository,
        shelterBookMarkJpaRepository: ShelterBookMarkJpaRepository,
    ): ShelterRepositoryPort {
        return ShelterRepositoryAdapter(
            shelterJpaRepository = shelterJpaRepository,
            shelterBookMarkJpaRepository = shelterBookMarkJpaRepository,
        )
    }
}
