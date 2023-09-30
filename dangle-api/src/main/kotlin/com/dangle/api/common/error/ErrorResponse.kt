package com.dangle.api.common.error

import com.dangle.common.DangleErrorCode

data class ErrorResponse(
        val code: Int,
        val message: String,
        val data: String? = null
){
    constructor(errorCode: DangleErrorCode,data:String?):this(
            code = errorCode.value,
            message = errorCode.message,
            data = data

    )
}