package com.dangle.common

enum class DangleErrorCode(
    val value: Int,
    val message: String,
) {
    // 4xxx. Not Found Error
    NOT_FOUND(4000, "잘못된 요청이에요."),
    NOT_FOUND_SHELTER(4001, "보호소를 찾을 수 없어요."),
}
