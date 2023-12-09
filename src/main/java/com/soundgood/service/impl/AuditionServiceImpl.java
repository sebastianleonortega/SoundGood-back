package com.soundgood.service.impl;

import com.soundgood.service.AuditionService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import org.springframework.core.io.Resource;


@Service
public class AuditionServiceImpl implements AuditionService {

    private int correctAnswersCount = 0;
    public String submitResults(String inputNumbers) {
        if (inputNumbers != null && !inputNumbers.trim().isEmpty()) {
            boolean isCorrect = validateNumbers(inputNumbers);
            if (isCorrect) {
                correctAnswersCount++;
            }
            return isCorrect ?
                    "¡Correcto! Has ingresado los números correctamente." :
                    "¡Incorrecto! Has cometido un error. El test ha terminado.";
        } else {
            return "No hay datos de entrada para validar.";
        }
    }

    public int getCorrectAnswersCount() {
        return correctAnswersCount;
    }

    public void resetCorrectAnswersCount() {
        correctAnswersCount = 0;
    }
    private boolean validateNumbers(String inputNumbers) {

        if ("432".equals(inputNumbers)) {
            return true;
        } else if ("976".equals(inputNumbers)) {
            return true;
        } else if ("321".equals(inputNumbers)) {
            return true;
        } else if ("765".equals(inputNumbers)) {
            return true;
        } else if ("987".equals(inputNumbers)) {
            return true;
        } else if ("654".equals(inputNumbers)) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Resource playAudio(int numero) {
        String audioFileName;

        switch (numero) {
            case 1:
                audioFileName = "432_Vol1";
                break;
            case 2:
                audioFileName = "976_Vol2";
                break;
            case 3:
                audioFileName = "976_Vol3";
                break;
            case 4:
                audioFileName = "321_Vol4";
                break;
            case 5:
                audioFileName = "765_Vol5";
                break;
            case 6:
                audioFileName = "987_Vol6";
                break;
            case 7:
                audioFileName = "654_Vol7";
                break;
            default:
                audioFileName = "audio_default";
        }

        String audioFilePath = "static/audio/" + audioFileName + ".mp3";
        return new ClassPathResource(audioFilePath);
    }

    @Override
    public Resource playAudioRight(int numero) {
        String audioRight;

        switch (numero) {
            case 1:
                audioRight = "600hz";
                break;
            case 2:
                audioRight = "500hz";
                break;
            case 3:
                audioRight = "400hz";
                break;
            case 4:
                audioRight = "300hz";
                break;
            case 5:
                audioRight = "200hz";
                break;
            case 6:
                audioRight = "150hz";
                break;
            default:
                audioRight = "audio_default";
        }
        String audioRightPath = "static/audio/" + audioRight + ".mp3";
        return new ClassPathResource(audioRightPath);
    }

    @Override
    public Resource playAudioLeft(int numero) {
        String audioLeft;

        switch (numero) {
            case 1:
                audioLeft = "600hz";
                break;
            case 2:
                audioLeft = "500hz";
                break;
            case 3:
                audioLeft = "400hz";
                break;
            case 4:
                audioLeft = "300hz";
                break;
            case 5:
                audioLeft = "200hz";
                break;
            case 6:
                audioLeft = "150hz";
                break;
            default:
                audioLeft = "audio_default";
        }
        String audioLeftPath = "static/audio/" + audioLeft + ".mp3";
        return new ClassPathResource(audioLeftPath);
    }
}
