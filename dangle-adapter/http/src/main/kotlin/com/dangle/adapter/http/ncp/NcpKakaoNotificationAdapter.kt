package com.dangle.adapter.http.ncp

import com.dangle.adapter.http.ncp.dto.NcpKakaoNotificationRequest
import com.dangle.adapter.http.ncp.dto.NcpTemplate
import com.dangle.adapter.http.ncp.service.NcpHeaderGenerator
import com.dangle.usecase.notification.port.out.KakaoNotificationPort
import feign.Request
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class NcpKakaoNotificationAdapter(
    @Value("\${ncp.bizMessageServiceId}") private val bizMessageServiceId: String,
    private val ncpHeaderGenerator: NcpHeaderGenerator,
    private val ncpKakaoNotificationClient: NcpKakaoNotificationClient,
) : KakaoNotificationPort {
    override fun send(
        targetPhoneNumber: String,
        templateCode: String,
        variables: Map<String, String>,
    ) {
        val template = NcpTemplate.findByCode(templateCode)
        val request = NcpKakaoNotificationRequest(
            plusFriendId = PLUS_FRIEND_ID,
            templateCode = template.templateCode,
            messages = listOf(
                NcpKakaoNotificationRequest.Message(
                    to = targetPhoneNumber,
                    title = template.title,
                    content = template.contents,
                    buttons = template.button?.let { listOf(it) } ?: listOf()
                )
            ),

        )
        val header = ncpHeaderGenerator.generate(
            method = Request.HttpMethod.POST,
            url = "/alimtalk/v2/services/$bizMessageServiceId/messages",
        )
        val response = ncpKakaoNotificationClient.send(
            timestamp = header.timeStamp,
            accessKey = header.accessKey,
            signature = header.signature,
            serviceId = bizMessageServiceId,
            request = request,
        )
        if (!response.isSuccess()) {
            // TODO(kang). 에러로그 남기기
        }
    }

    companion object {
        private const val PLUS_FRIEND_ID = "@dangledangle"
    }
}
