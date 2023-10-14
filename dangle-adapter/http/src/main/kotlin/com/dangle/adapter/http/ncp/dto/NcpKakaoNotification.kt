package com.dangle.adapter.http.ncp.dto

data class NcpKakaoNotificationRequest(
    val plusFriendId: String,
    val templateCode: String,
    val messages: List<Message>,
    val reserveTime: String, // yyyy-MM-dd HH:mm
    val reserveTimeZone: String,
) {
    data class Message(
        val countryCode: String,
        val to: String,
        val title: String,
        val content: String,
        val headerContent: String,
        val itemHighlight: ItemHighlight,
        val item: List<Item>,
        val buttons: List<Button>,
        val useSmsFailover: Boolean,
        val failoverConfig: FailoverConfig,
    )

    data class ItemHighlight(
        val title: String,
        val description: String,
    )

    data class Item(
        val list: List<ItemContents>,
        val summary: ItemContents,
    )

    data class ItemContents(
        val title: String,
        val description: String,
    )

    data class Button(
        val type: String,
        val name: String,
        val linkMobile: String,
        val linkPc: String,
        val schemeIos: String,
        val schemeAndroid: String,
    )

    data class FailoverConfig(
        val type: String,
        val from: String,
        val subject: String,
        val content: String,
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
