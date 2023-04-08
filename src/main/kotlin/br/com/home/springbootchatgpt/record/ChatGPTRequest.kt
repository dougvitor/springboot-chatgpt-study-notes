package br.com.home.springbootchatgpt.record

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class ChatGPTRequest(
    val model: String,
    val prompt: String,
    val temperature: Double,
    val maxTokens: Int,
    val topP: Double,
    val frequencyPenalty: Double,
    val presencePenalty: Double
)