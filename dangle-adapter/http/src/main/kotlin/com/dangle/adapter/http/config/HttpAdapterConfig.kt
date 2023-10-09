package com.dangle.adapter.http.config

import com.dangle.adapter.http.kakao.KakaoNotificationAdapter
import com.dangle.adapter.http.kakao.KakaoNotificationClient
import com.dangle.usecase.notification.port.out.KakaoNotificationPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
    FeignConfig::class,
)
class HttpAdapterConfig {
    @Bean
    fun kakaoNotificationPort(
        kakaoNotificationClient: KakaoNotificationClient,
    ): KakaoNotificationPort {
        return KakaoNotificationAdapter(kakaoNotificationClient)
    }
}
