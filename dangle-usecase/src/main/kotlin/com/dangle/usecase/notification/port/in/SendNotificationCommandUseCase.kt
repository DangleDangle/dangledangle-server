package com.dangle.usecase.notification.port.`in`

interface SendNotificationCommandUseCase {
    fun invoke(request : Request)

    sealed interface Request {
        val contents: String

        data class KakaoTalk(
            val phoneNumber: String,
            override val contents: String,
        ) : Request
    }
}
