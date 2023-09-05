package com.dangle.usecase.shelter.port.out

import com.dangle.domain.shelter.Shelter
import com.dangle.domain.shelter.ShelterBookMark
import com.dangle.domain.volunteer.Volunteer

interface ShelterRepositoryPort {
    fun findById(id: Long): Shelter
    fun findBookMark(shelterId: Long, volunteerId: Long): ShelterBookMark
    fun saveBookMark(shelterBookMark: ShelterBookMark): ShelterBookMark
}
