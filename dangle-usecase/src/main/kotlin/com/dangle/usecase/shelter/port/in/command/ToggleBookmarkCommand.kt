package com.dangle.usecase.shelter.port.`in`.command

import com.dangle.domain.shelter.ShelterBookMark
import com.dangle.usecase.shelter.port.out.ShelterRepositoryPort

class ToggleBookmarkCommand(
    private val shelterRepositoryPort: ShelterRepositoryPort,
): ToggleBookmarkCommandUseCase {
    override fun invoke(command: ToggleBookmarkCommandUseCase.Command): ShelterBookMark {
        val bookMark = shelterRepositoryPort.findBookMark(
            shelterId = command.shelterId,
            volunteerId = command.volunteerId
        ).toggle()
        return shelterRepositoryPort.saveBookMark(bookMark)
    }
}
