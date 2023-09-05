package com.dangle.domain.shelter

data class ShelterBookMark(
    val shelterId: Long,
    val volunteerId: Long,
    val bookMarked: Boolean = false,
) {
    fun toggle(): ShelterBookMark {
        return this.copy(bookMarked = !bookMarked)
    }
}
