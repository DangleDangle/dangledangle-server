package com.dangle.adapter.redis.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisPassword
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class RedisConfig {
    @Bean
    fun redisConnectionFactory(
        @Value("\${redis.host}") host: String,
        @Value("\${redis.port}") port: Int,
        @Value("\${redis.password}") password: String?,
    ): RedisConnectionFactory {
        return LettuceConnectionFactory(
            RedisStandaloneConfiguration(host, port).apply {
                this.password = RedisPassword.of(password)
            }
        )
    }

    @Bean
    fun redisMessageListenerContainer(
        connectionFactory: RedisConnectionFactory,
    ): RedisMessageListenerContainer {
        return RedisMessageListenerContainer().apply {
            this.setConnectionFactory(connectionFactory)
        }
    }

    @Bean
    fun redisTemplate(
        connectionFactory: RedisConnectionFactory,
    ): RedisTemplate<String, Any> {
        return RedisTemplate<String, Any>().apply {
            this.connectionFactory = connectionFactory
            this.keySerializer = StringRedisSerializer()
            this.valueSerializer = GenericJackson2JsonRedisSerializer()
        }
    }
}
