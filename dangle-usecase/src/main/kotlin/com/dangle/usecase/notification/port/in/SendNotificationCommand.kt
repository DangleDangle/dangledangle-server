package com.dangle.usecase.notification.port.`in`

import com.dangle.usecase.notification.port.out.KakaoNotificationPort
import org.springframework.stereotype.Service

@Service
class SendNotificationCommand(
    private val kakaoNotificationPort: KakaoNotificationPort,
) : SendNotificationCommandUseCase {
    override fun invoke(request: SendNotificationCommandUseCase.Request) {
        when (request) {
            is SendNotificationCommandUseCase.Request.KakaoTalk -> {
                kakaoNotificationPort.send(
                    targetPhoneNumber = request.phoneNumber,
                    templateCode = request.templateName,
                    variables = request.variables,
                )
            }
        }
    }
}
