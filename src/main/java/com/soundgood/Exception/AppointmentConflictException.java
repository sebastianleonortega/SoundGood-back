package com.soundgood.Exception;

public class AppointmentConflictException extends RuntimeException{
    public AppointmentConflictException(String message) {
        super(message);
    }
}
