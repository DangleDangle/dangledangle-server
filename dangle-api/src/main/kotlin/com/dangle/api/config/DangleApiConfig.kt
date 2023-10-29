package com.dangle.api.config

import com.dangle.adapter.http.config.FeignConfig
import com.dangle.adapter.persistence.config.RepositoryAdapterConfig
import com.dangle.adapter.redis.config.EmbeddedRedisConfig
import com.dangle.adapter.redis.config.RedisConfig
import com.dangle.api.event.KakaoNotificationRedisListener
import com.dangle.usecase.notification.port.`in`.SendNotificationCommandUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer

@Import(
    FeignConfig::class,
    RepositoryAdapterConfig::class,
    RedisConfig::class,
    EmbeddedRedisConfig::class,
)
@Configuration
class DangleApiConfig {
    @Bean
    fun redisMessageListenerContainer(
        connectionFactory: RedisConnectionFactory,
        sendNotificationCommandUseCase: SendNotificationCommandUseCase,
    ): RedisMessageListenerContainer {
        return RedisMessageListenerContainer().apply {
            this.setConnectionFactory(connectionFactory)
            this.addMessageListener(
                KakaoNotificationRedisListener(sendNotificationCommandUseCase),
                ChannelTopic("dangle.notification.kakao"),
            )
        }
    }
}
