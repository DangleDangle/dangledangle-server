package com.dangle.common.utils

import java.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object HmacSHA256 {
    private const val ALGORITHM = "HmacSHA256"
    private val encoder = Base64.getEncoder()
    private val decoder = Base64.getDecoder()

    fun encrypt(str: String, secretKey: String): String {
        val rawHmac = hmac(secretKey)
            .doFinal(str.toByteArray(Charsets.UTF_8))
        return encoder.encode(rawHmac).toString()
    }

    fun decrypt(str: String, secretKey: String): String {
        val byteStr = decoder.decode(str.toByteArray(Charsets.UTF_8))
        return hmac(secretKey).doFinal(byteStr).toString()
    }

    private fun hmac(secretKey: String): Mac {
        val signingKey = SecretKeySpec(secretKey.toByteArray(), "HmacSHA256")
        return Mac.getInstance(ALGORITHM)
            .also { it.init(signingKey) }
    }
}
