package com.dangle.adapter.http.kakao

import com.dangle.adapter.http.kakao.dto.KakaoNotificationRequest
import com.dangle.adapter.http.kakao.dto.KakaoNotificationResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "kakaoNotifiactionFeignClient", url = "TBD")
interface KakaoNotificationClient {
    @PostMapping(value = ["/TBD"])
    fun send(@RequestBody request: KakaoNotificationRequest): KakaoNotificationResponse
}
