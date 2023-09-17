package com.dangle.common

class DangleException(
    errorCode: DangleErrorCode,
    debug: String? = null,
    throwable: Throwable? = null,
) : RuntimeException("$errorCode${debug?.let { " - $it" }}", throwable)
