package br.com.home.springbootchatgpt.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig(
    private val builder: WebClient.Builder,
    @Value("\${openai.api.key}") private val apiKey: String
) {

    @Bean
    fun createWebClient(): WebClient =
        builder
            .baseUrl("https://api.openai.com/v1/completions")
            .defaultHeader("Content-Type", "application/json")
            .defaultHeader("Authorization", "Bearer $apiKey")
            .build()

}