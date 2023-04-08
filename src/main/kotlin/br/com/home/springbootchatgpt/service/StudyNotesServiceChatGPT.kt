package br.com.home.springbootchatgpt.service

import br.com.home.springbootchatgpt.record.ChatGPTRequest
import br.com.home.springbootchatgpt.record.ChatGPTResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class StudyNotesServiceChatGPT @Autowired constructor(
    private val webClient: WebClient
) {

    fun createStudyNotes(topic: String): Mono<ChatGPTResponse> =
        createStudyNotesRequest(topic).let { request ->
            webClient.post()
                .bodyValue(request)
                .retrieve()
                .bodyToMono(object : ParameterizedTypeReference<ChatGPTResponse>() {})
        }

    private fun createStudyNotesRequest(topic: String): ChatGPTRequest = ChatGPTRequest(
        model = "text-davinci-003",
        prompt = "Quais são os pontos chaves que devo estudar sobre o seguinte assunto: $topic",
        temperature = 0.3,
        maxTokens = 2000,
        topP = 1.0,
        frequencyPenalty = 0.0,
        presencePenalty = 0.0
    )

}

