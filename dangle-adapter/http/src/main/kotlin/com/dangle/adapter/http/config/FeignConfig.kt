package com.dangle.adapter.http.config

import com.dangle.adapter.http.ncp.NcpKakaoNotificationClient
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.FeignClientProperties

@EnableFeignClients(
    clients = [
        NcpKakaoNotificationClient::class,
    ]
)
@EnableConfigurationProperties(FeignClientProperties::class)
class FeignConfig
