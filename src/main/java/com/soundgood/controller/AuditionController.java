package com.soundgood.controller;

import com.soundgood.model.AuditionResult;
import com.soundgood.service.impl.AuditionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;


@RestController
@RequestMapping("/api/test-audition")
public class AuditionController {

    private final AuditionServiceImpl auditionService;

    @Autowired
    public AuditionController(AuditionServiceImpl auditionService) {
        this.auditionService = auditionService;
    }

    @PostMapping("/submit-results")
    public String submitResults(@RequestBody AuditionResult auditionResult) {
        return auditionService.submitResults(auditionResult.getInputNumbers());
    }

    @GetMapping("/correct-answers-count")
    public int getCorrectAnswersCount() {
        return auditionService.getCorrectAnswersCount();
    }

    @GetMapping("/reset-correct-answers-count")
    public void resetCorrectAnswersCount() {
        auditionService.resetCorrectAnswersCount();
    }

    @GetMapping(value = "/audio/{numero}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public Resource getAudio(@PathVariable int numero) {
        return auditionService.playAudio(numero);
    }

    @GetMapping(value = "/audio-right/{numero}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public Resource getRightAudio(@PathVariable int numero) {
        return auditionService.playAudioRight(numero);
    }

    @GetMapping(value = "/audio-left/{numero}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public Resource getLeftAudio(@PathVariable int numero) {
        return auditionService.playAudioLeft(numero);
    }

}

