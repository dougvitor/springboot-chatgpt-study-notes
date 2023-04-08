package br.com.home.springbootchatgpt.controller

import br.com.home.springbootchatgpt.service.StudyNotesServiceChatGPT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class StudyNotesController @Autowired constructor(private val studyNotesService: StudyNotesServiceChatGPT){

    @PostMapping("/study-notes")
    fun createStudyNotes( @RequestBody topic: String): Mono<String> =
        studyNotesService.createStudyNotes(topic)
            .map { it.choices.first().text }
}