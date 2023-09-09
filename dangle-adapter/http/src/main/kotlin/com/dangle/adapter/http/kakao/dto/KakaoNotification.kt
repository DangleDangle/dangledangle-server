package com.dangle.adapter.http.kakao.dto

class KakaoNotificationRequest(
    val phoneNumber: String,
    val contents: String,
)

class KakaoNotificationResponse {
    fun isSuccess(): Boolean = true
}
