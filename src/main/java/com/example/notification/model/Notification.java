package com.example.notification.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Notification {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final String channel;
    private final String recipient;
    private final String message;
    private final LocalDateTime timestamp;
    private final boolean successful;
    private final String failureReason;

    public Notification(String channel, String recipient, String message, boolean successful, String failureReason) {
        this.channel = channel;
        this.recipient = recipient;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.successful = successful;
        this.failureReason = failureReason;
    }

    public String getChannel() {
        return channel;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getFailureReason() {
        return failureReason;
    }

    @Override
    public String toString() {
        String status = successful ? "SUCCESS" : "FAILED (" + failureReason + ")";
        return String.format("[%s] %s | Channel: %s | Recipient: %s | Message: \"%s\"",
                timestamp.format(FORMATTER), status, channel, recipient, message);
    }
}
