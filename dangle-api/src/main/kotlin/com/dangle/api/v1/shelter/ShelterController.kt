package com.dangle.api.v1.shelter

import com.dangle.api.common.resolver.VolunteerAuthentication
import com.dangle.api.common.resolver.VolunteerAuthenticationInfo
import com.dangle.usecase.shelter.port.`in`.command.ToggleBookmarkCommandUseCase
import com.dangle.usecase.shelter.port.`in`.query.GetShelterQueryUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ShelterController(
    private val getShelterQueryUseCase: GetShelterQueryUseCase,
    private val toggleBookmarkCommandUseCase: ToggleBookmarkCommandUseCase,
) {
    @GetMapping("/{shelterId}")
    fun getShelterInfo(
        @PathVariable shelterId: Long,
        @VolunteerAuthentication volunteerInfo: VolunteerAuthenticationInfo?,
    ): GetShelterResponse {
        return getShelterQueryUseCase.invoke(shelterId).let {
            GetShelterResponse(
                id = it.id,
                name = it.name,
                email = "TODO",
                phoneNumber = it.phoneNumber,
                description = it.description,
                address = GetShelterResponse.GetShelterAddressInfoDto(
                    address = it.address.address,
                    addressDetail = it.address.addressDetail,
                    postalCode = it.address.postalCode,
                    latitude = it.address.latitude,
                    longitude = it.address.longitude,
                ),
                profileImageUrl = it.profileImageUrl,
                bookMarked = false, // TODO(kang) 북마크 처리 필요
            )
        }
    }

    @PostMapping("/{shelterId}/bookmark")
    fun bookmarkShelter(
        @PathVariable shelterId: Long,
        @VolunteerAuthentication volunteerInfo: VolunteerAuthenticationInfo
    ): BookMarkShelterResponse {
        return toggleBookmarkCommandUseCase.invoke(
            ToggleBookmarkCommandUseCase.Command(
                shelterId = shelterId,
                volunteerId = volunteerInfo.volunteerId,
            )
        ).let {
            BookMarkShelterResponse(
                shelterId = it.shelterId,
                volunteerId = it.volunteerId,
                bookMarked = it.bookMarked,
            )
        }
    }

    data class GetShelterResponse(
        val id: Long,
        val name: String,
        val email: String,
        val phoneNumber: String,
        val description: String,
        val address: GetShelterAddressInfoDto,
        val bookMarked: Boolean,
        val outLinks: List<GetOutLinkInfoDto> = listOf(),
        val profileImageUrl: String? = null,
        val parkingInfo: GetShelterParkingInfoDto? = null,
        val bankAccount: GetBankAccountInfoDto? = null,
        val notice: String? = null,
    ) {
        data class GetShelterAddressInfoDto(
            val address: String,
            val addressDetail: String,
            val postalCode: String,
            val latitude: Double,
            val longitude: Double,
        )
        data class GetBankAccountInfoDto(
            val bankName: String,
            val accountNumber: String
        )
        data class GetOutLinkInfoDto(
            val outLinkType: String,
            val url: String
        )

        data class GetShelterParkingInfoDto(
            val parkingEnabled: Boolean,
            val parkingNotice: String?
        )
    }

    data class BookMarkShelterResponse(
        val shelterId: Long,
        val volunteerId: Long,
        val bookMarked: Boolean
    )
}
