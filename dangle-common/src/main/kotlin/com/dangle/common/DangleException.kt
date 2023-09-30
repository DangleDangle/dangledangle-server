package com.dangle.common

class DangleException(
    val errorCode: DangleErrorCode,
    val debug: String? = null,
    val throwable: Throwable? = null,
) : RuntimeException("$errorCode${debug?.let { " - $it" }}", throwable)
