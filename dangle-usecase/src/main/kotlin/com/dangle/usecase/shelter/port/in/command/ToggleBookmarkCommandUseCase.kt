package com.dangle.usecase.shelter.port.`in`.command

import com.dangle.domain.shelter.ShelterBookMark

interface ToggleBookmarkCommandUseCase {
    fun invoke(command: Command): ShelterBookMark
    data class Command(
        val shelterId: Long,
        val volunteerId: Long,
    )
}
