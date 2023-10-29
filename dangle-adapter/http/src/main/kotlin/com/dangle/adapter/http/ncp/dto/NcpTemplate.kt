package com.dangle.adapter.http.ncp.dto

import com.dangle.common.DangleErrorCode
import com.dangle.common.DangleException

enum class NcpTemplate(
    val templateCode: String,
    val title: String,
    val buttons: List<Button>,
    val contents: String,
) {
    UPDATE_1(
        templateCode = "update1",
        title = "[이벤트 정보 업데이트]",
        buttons = listOf(
            Button(
                type = "WL",
                name = "확인하러가기",
                linkMobile = "https://dangle.co.kr/",
                linkPc = "https://dangle.co.kr/",
            ),
        ),
        contents = """
            %s님, 참석/대기 신청하신 이벤트의 정보가 변경되어 연락드렸어요.

            - 이벤트명: %s
            - 날짜: %s
            - 시간: %s
        """.trimIndent()
    ) {
        fun getContents(
            name: String,
            event: String,
            date: String,
            time: String,
        ) = """
            ${name}님, 참석/대기 신청하신 이벤트의 정보가 변경되어 연락드렸어요.

            - 이벤트명: $event
            - 날짜: $date
            - 시간: $time
        """.trimIndent()
    },
    ;

    companion object {
        fun findByCode(templateCode: String): NcpTemplate {
            return values().find { it.templateCode == templateCode }
                ?: throw DangleException(DangleErrorCode.NOT_FOUND, "알림톡 템플릿 없음.")
        }
    }
}
