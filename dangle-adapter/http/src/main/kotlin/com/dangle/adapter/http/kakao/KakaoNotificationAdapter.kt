package com.dangle.adapter.http.kakao

import com.dangle.adapter.http.kakao.dto.KakaoNotificationRequest
import com.dangle.usecase.notification.port.out.KakaoNotificationPort

class KakaoNotificationAdapter(
    private val kakaoNotificationClient: KakaoNotificationClient,
) : KakaoNotificationPort {
    override fun send(
        targetPhoneNumber: String,
        templateName: String,
        variables: Map<String, String>,
    ) {
        // TOOD(kang) 연동 필요
        val response = kakaoNotificationClient.send(KakaoNotificationRequest())
        if (!response.isSuccess()) {
            // TODO(kang). 에러로그 남기기
        }
    }
}
