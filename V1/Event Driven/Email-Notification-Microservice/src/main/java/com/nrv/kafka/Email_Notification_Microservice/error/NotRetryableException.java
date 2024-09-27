package com.nrv.kafka.Email_Notification_Microservice.error;

public class NotRetryableException extends RuntimeException {
    public NotRetryableException(String message) {
        super(message);
    }

    public NotRetryableException(Throwable cause) {
        super(cause);
    }
}



