package com.dangle.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.dangle"], exclude = [ErrorMvcAutoConfiguration::class])
@ConfigurationPropertiesScan(basePackages = ["com.dangle"])
class DangleApiApplication

fun main(args: Array<String>) {
    runApplication<DangleApiApplication>(*args)
}
