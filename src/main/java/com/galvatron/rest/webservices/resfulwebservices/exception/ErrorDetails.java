package com.galvatron.rest.webservices.resfulwebservices.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

    public ErrorDetails(LocalDateTime timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "timeStamp=" + timeStamp +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    private LocalDateTime timeStamp;
    private String message;
    private String details;
}
