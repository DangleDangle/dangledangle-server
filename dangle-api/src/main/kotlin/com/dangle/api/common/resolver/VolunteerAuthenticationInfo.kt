package com.dangle.api.common.resolver

import com.dangle.domain.common.vo.Email

data class VolunteerAuthenticationInfo(
    val volunteerId: Long,
    val email: Email,
)
