package com.primeevilsoftware.GameServer.exceptions;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class LevelHighScoreException extends RuntimeException {

    private LocalDateTime timestamp;
    private String message;
    private HttpStatus httpStatus;

    public LevelHighScoreException() {
        timestamp = LocalDateTime.now();
    }

    public LevelHighScoreException(String message) {
        this();
        this.message = message;
    }

    public LevelHighScoreException(String message, HttpStatus httpStatus) {
        this();
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
