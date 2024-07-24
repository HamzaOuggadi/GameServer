package com.primeevilsoftware.GameServer.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class PlayerException extends RuntimeException {

    private String message;
    private LocalDateTime timestamp;
    private HttpStatus httpStatus;

    public PlayerException() {
        timestamp = LocalDateTime.now();
    }

    public PlayerException(String message) {
        this();
        this.message = message;
    }

    public PlayerException(String message, HttpStatus httpStatus) {
        this();
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
