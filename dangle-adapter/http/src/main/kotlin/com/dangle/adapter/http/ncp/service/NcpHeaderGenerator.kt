package com.dangle.adapter.http.ncp.service

import com.dangle.common.utils.HmacSHA256
import feign.Request.HttpMethod
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class NcpHeaderGenerator(
    @Value("\${ncp.accessKey}") private val accessKey: String,
    @Value("\${ncp.secret}") private val secret: String,
) {
    fun generate(
        method: HttpMethod,
        url: String,
    ): NcpHeader {
        val timeStamp = Instant.now().toEpochMilli().toString()
        val message = "$method $url\n$timeStamp\n$accessKey"
        val signature = HmacSHA256.encrypt(message, secret)

        return NcpHeader(timeStamp, accessKey, signature)
    }

    data class NcpHeader(
        val timeStamp: String,
        val accessKey: String,
        val signature: String,
    )
}
