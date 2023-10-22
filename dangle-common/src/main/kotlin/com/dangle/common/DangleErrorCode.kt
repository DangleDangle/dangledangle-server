package com.dangle.common

enum class DangleErrorCode(
    val value: Int,
    val message: String,
) {
    // 40xx. Bad Request
    BAD_REQUEST(4000, "잘못된 요청이에요."),
    // 41xx. Not Found Error
    NOT_FOUND(4100, "정보를 찾을 수 없어요."),
    NOT_FOUND_SHELTER(4101, "보호소를 찾을 수 없어요."),

    // 5xxx. Internal Server Error
    INTERNAL_SERVER_ERROR(5000,"시스템 내부 에러가 발생했어요.")
}
