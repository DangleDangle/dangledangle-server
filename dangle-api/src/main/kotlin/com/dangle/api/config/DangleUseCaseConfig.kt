package com.dangle.api.config

import com.dangle.adapter.persistence.config.RepositoryAdapterConfig
import com.dangle.usecase.shelter.port.`in`.command.ToggleBookmarkCommand
import com.dangle.usecase.shelter.port.`in`.command.ToggleBookmarkCommandUseCase
import com.dangle.usecase.shelter.port.`in`.query.GetShelterQuery
import com.dangle.usecase.shelter.port.`in`.query.GetShelterQueryUseCase
import com.dangle.usecase.shelter.port.out.ShelterRepositoryPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(
    RepositoryAdapterConfig::class,
)
@Configuration
class DangleUseCaseConfig {
    @Bean
    fun getShelterQueryUseCase(
        shelterRepositoryPort: ShelterRepositoryPort,
    ): GetShelterQueryUseCase {
        return GetShelterQuery(
            shelterRepositoryPort = shelterRepositoryPort,
        )
    }

    @Bean
    fun toggleBookmarkCommandUseCase(
        shelterRepositoryPort: ShelterRepositoryPort,
    ): ToggleBookmarkCommandUseCase {
        return ToggleBookmarkCommand(
            shelterRepositoryPort = shelterRepositoryPort,
        )
    }
}
