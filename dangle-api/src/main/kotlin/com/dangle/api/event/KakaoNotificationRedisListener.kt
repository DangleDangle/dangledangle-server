package com.dangle.api.event

import com.dangle.usecase.notification.port.`in`.SendNotificationCommandUseCase
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener

class KakaoNotificationRedisListener(
    private val sendNotificationUseCase: SendNotificationCommandUseCase,
) : MessageListener {
    // TODO(kang) PropertyNamingStrategies 수정 필요
    private val objectMapper = jacksonObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)

    override fun onMessage(message: Message, pattern: ByteArray?) {
        val event = objectMapper.readValue(message.body, KakaoNotificationEvent::class.java)

        sendNotificationUseCase.invoke(
            SendNotificationCommandUseCase.Request.KakaoTalk(
                phoneNumber = event.phoneNumber,
                templateName = event.templateName,
                variables = event.variables
            )
        )
    }

    data class KakaoNotificationEvent(
        val id: Long,
        val phoneNumber: String,
        val templateName: String,
        val variables: Map<String, String>,
    )
}
