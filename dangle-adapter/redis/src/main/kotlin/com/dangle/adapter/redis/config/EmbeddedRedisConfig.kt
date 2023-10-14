package com.dangle.adapter.redis.config

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import redis.embedded.RedisServer

@Configuration
class EmbeddedRedisConfig(
    @Value("\${spring.data.redis.port}") private val redisPort: Int,
) {
    private val redisServer: RedisServer = RedisServer(redisPort)

    @PostConstruct
    private fun startRedis() {
        redisServer.start()
    }

    @PreDestroy
    private fun stopRedis() {
        redisServer.stop()
    }
}
