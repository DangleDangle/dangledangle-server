package com.dangle.adapter.http.kakao

import com.dangle.adapter.http.kakao.dto.KakaoNotificationRequest
import com.dangle.usecase.notification.port.out.KakaoNotificationPort

class KakaoNotificationAdapter(
    private val kakaoNotificationClient: KakaoNotificationClient,
) : KakaoNotificationPort {
    override fun send(targetPhoneNumber: String, contents: String) {
        val response = kakaoNotificationClient.send(
            KakaoNotificationRequest(
                phoneNumber = targetPhoneNumber,
                contents = contents
            )
        )
        if (!response.isSuccess()) {
            // TODO(kang). 에러로그 남기기
        }
    }
}
