package com.dangle.api.common.error

import com.dangle.api.common.phase.ActiveProfilesResolver
import com.dangle.api.common.response.ApiResponse
import com.dangle.common.DangleErrorCode
import com.dangle.common.DangleException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class DangleApiExceptionControllerAdvice(
        private val activeProfilesResolver: ActiveProfilesResolver
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(DangleException::class)
    fun handleDangleException(e: DangleException): ResponseEntity<ApiResponse<Any?>>{
        return ResponseEntity(
                ApiResponse.error(
                        errorCode = e.errorCode,
                        error = e.toError(),
                        debug = e.toDebug()
                ),
                e.errorCode.httpStatusCode()
        )
    }

    // 별도로 Exception 을 처리할 것들은 이앞에서 다시 처리할 것
    @ExceptionHandler(Throwable::class)
    fun handleUnKnownException(e: Throwable): ResponseEntity<ApiResponse<Any?>>{
        logger.error(e.stackTraceToString())
        return handleDangleException(
                DangleException(
                    errorCode = DangleErrorCode.INTERNAL_SERVER_ERROR,
                    debug = e.message,
                    throwable = e
            )
        )
    }

    private fun DangleErrorCode.httpStatusCode(): HttpStatusCode{
        return when (value) {
            in 4000 until 4100 -> HttpStatus.BAD_REQUEST
            in 4100 until 4200 -> HttpStatus.NOT_FOUND
            in 5000 until 5100 -> HttpStatus.INTERNAL_SERVER_ERROR
            else -> HttpStatus.INTERNAL_SERVER_ERROR
        }
    }


    private fun DangleException.toError(): String {
        return this.errorCode.name
    }
    private fun DangleException.toDebug(): String?{
        if(activeProfilesResolver.isPrd()){
            return null
        }
        return this.stackTraceToString()
    }
}