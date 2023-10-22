package com.dangle.api.common.response

import com.dangle.api.common.error.ErrorResponse
import com.dangle.common.DangleErrorCode

class ApiResponse<T> private constructor(
        val result: ResponseType,
        val data: T? = null,
        val error: ErrorResponse? = null,
        val debug: String? = null
){

    companion object{
        fun<T> success(result: T): ApiResponse<T>{
            return ApiResponse(
                    result = ResponseType.SUCCESS,
                    data = result,
            )
        }

        fun<T> success(result: List<T>) : ApiResponse<List<T>>{
            return ApiResponse(
                    result = ResponseType.SUCCESS,
                    data =  result
            )
        }

        fun<T> error(errorCode: DangleErrorCode,error: String?, debug:String? ):ApiResponse<T>{
            return ApiResponse(
                    result = ResponseType.ERROR,
                    data = null,
                    error = ErrorResponse(
                            errorCode = errorCode,
                            data = error,
                    ),
                    debug = debug
            )
        }
     }
    enum class ResponseType{
        SUCCESS,ERROR
    }

    override fun toString(): String {
        return "ApiResponse(result=$result, data=$data, error=$error, debug=$debug)"
    }
}