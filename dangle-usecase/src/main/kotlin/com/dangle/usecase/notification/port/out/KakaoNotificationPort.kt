package com.dangle.usecase.notification.port.out

interface KakaoNotificationPort {
    fun send(
        targetPhoneNumber: String,
        templateName: String,
        variables: Map<String, String>,
    )
}
