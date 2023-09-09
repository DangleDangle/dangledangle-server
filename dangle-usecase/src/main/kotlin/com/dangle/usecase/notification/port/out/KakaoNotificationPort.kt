package com.dangle.usecase.notification.port.out

interface KakaoNotificationPort {
    fun send(
        targetPhoneNumber: String,
        contents: String,
    )
}
