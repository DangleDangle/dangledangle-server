package com.dangle.adapter.http.ncp.dto

data class NcpKakaoNotificationRequest(
    val plusFriendId: String,
    val templateCode: String,
    val messages: List<Message>,
) {
    data class Message(
        val countryCode: String = "82",
        val to: String,
        val title: String,
        val content: String,
        val buttons: List<Button>,
    )
}

data class NcpKakaoNotificationResponse(
    val requestId: String,
    val requestTime: String,
    val statusCode: String,
    val statusName: String,
    val messages: List<Message>,
) {
    fun isSuccess(): Boolean = true

    data class Message(
        val messageId: String,
        val countryCode: String,
        val to: String,
        val content: String,
        val requestStatusCode: String,
        val requestStatusName: String,
        val requestStatusDesc: String,
        val useSmsFailover: Boolean,
    )
}
