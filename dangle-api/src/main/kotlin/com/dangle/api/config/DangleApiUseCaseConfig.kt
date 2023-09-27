package com.dangle.api.config

import com.dangle.usecase.notification.port.`in`.SendNotificationCommand
import com.dangle.usecase.notification.port.`in`.SendNotificationCommandUseCase
import com.dangle.usecase.notification.port.out.KakaoNotificationPort
import com.dangle.usecase.shelter.port.`in`.command.ToggleBookmarkCommand
import com.dangle.usecase.shelter.port.`in`.command.ToggleBookmarkCommandUseCase
import com.dangle.usecase.shelter.port.`in`.query.GetShelterQuery
import com.dangle.usecase.shelter.port.`in`.query.GetShelterQueryUseCase
import com.dangle.usecase.shelter.port.out.ShelterRepositoryPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DangleApiUseCaseConfig {
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

    @Bean
    fun sendNotificationCommandUseCase(
        kakaoNotificationPort: KakaoNotificationPort,
    ): SendNotificationCommandUseCase{
        return SendNotificationCommand(
            kakaoNotificationPort = kakaoNotificationPort,
        )
    }
}
