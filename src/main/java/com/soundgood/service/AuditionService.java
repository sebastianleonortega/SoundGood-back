package com.soundgood.service;

import org.springframework.core.io.Resource;


public interface AuditionService {

    Resource playAudio(int numero);
    Resource playAudioRight(int numero);
    Resource playAudioLeft(int numero);
}
