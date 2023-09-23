package com.dangle.adapter.redis.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "redis")
data class RedisConfiguration(
    val host: String,
    val port: Int,
    val password: String?,
)
