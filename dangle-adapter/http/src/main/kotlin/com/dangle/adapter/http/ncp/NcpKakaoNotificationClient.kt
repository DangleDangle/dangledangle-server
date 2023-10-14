package com.dangle.adapter.http.ncp

import com.dangle.adapter.http.ncp.dto.NcpKakaoNotificationRequest
import com.dangle.adapter.http.ncp.dto.NcpKakaoNotificationResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "ncpKakaoNotificationFeignClient", url = "https://sens.apigw.ntruss.com/alimtalk/v2")
interface NcpKakaoNotificationClient {
    @PostMapping(value = ["services/{serviceId}/messages"])
    fun send(
        @RequestHeader("x-ncp-apigw-timestamp") timestamp: String, // Millisecond
        @RequestHeader("x-ncp-apigw-x-ncp-iam-access-key") subAccountAccessKey: String,
        @RequestHeader("x-ncp-apigw-signature-v2") apiGatewaySignature: String, // HmacSHA256
        @PathVariable("serviceId") serviceId: String,
        @RequestBody request: NcpKakaoNotificationRequest
    ): NcpKakaoNotificationResponse
}
