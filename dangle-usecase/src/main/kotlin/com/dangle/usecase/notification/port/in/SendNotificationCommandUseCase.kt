package com.dangle.usecase.notification.port.`in`

interface SendNotificationCommandUseCase {
    fun invoke(request: Request)

    sealed interface Request {
        data class KakaoTalk(
            val phoneNumber: String,
            val templateName: String,
            val variables: Map<String, String>,
        ) : Request
    }
}
