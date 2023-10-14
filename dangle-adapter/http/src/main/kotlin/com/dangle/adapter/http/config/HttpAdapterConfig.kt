package com.dangle.adapter.http.config

import com.dangle.adapter.http.ncp.NcpKakaoNotificationAdapter
import com.dangle.adapter.http.ncp.NcpKakaoNotificationClient
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
        ncpKakaoNotificationClient: NcpKakaoNotificationClient,
    ): KakaoNotificationPort {
        return NcpKakaoNotificationAdapter(ncpKakaoNotificationClient)
    }
}
