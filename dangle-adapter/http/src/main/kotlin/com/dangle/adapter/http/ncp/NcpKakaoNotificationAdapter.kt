package com.dangle.adapter.http.ncp

import com.dangle.adapter.http.ncp.dto.NcpKakaoNotificationRequest
import com.dangle.usecase.notification.port.out.KakaoNotificationPort

class NcpKakaoNotificationAdapter(
    private val ncpKakaoNotificationClient: NcpKakaoNotificationClient,
) : KakaoNotificationPort {
    override fun send(
        targetPhoneNumber: String,
        templateName: String,
        variables: Map<String, String>,
    ) {
        val request = NcpKakaoNotificationRequest(
            plusFriendId = "TBD",
            templateCode = "TBD",
            messages = listOf(),
            reserveTime = "TBD",
            reserveTimeZone = "TBD"

        )
        val response = ncpKakaoNotificationClient.send(
            timestamp = "TBD",
            subAccountAccessKey = "TBD",
            apiGatewaySignature = "TBD",
            serviceId = "TBD",
            request = request,
        )
        if (!response.isSuccess()) {
            // TODO(kang). 에러로그 남기기
        }
    }
}
