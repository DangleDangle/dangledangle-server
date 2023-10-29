package com.dangle.usecase.notification.port.out

interface KakaoNotificationPort {
    fun send(
        targetPhoneNumber: String,
        templateCode: String,
        variables: Map<String, String>,
    )
}
