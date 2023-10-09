package com.dangle.adapter.http.config

import com.dangle.adapter.http.kakao.KakaoNotificationClient
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.FeignClientProperties

@EnableFeignClients(
    clients = [
        KakaoNotificationClient::class,
    ]
)
@EnableConfigurationProperties(FeignClientProperties::class)
class FeignConfig
