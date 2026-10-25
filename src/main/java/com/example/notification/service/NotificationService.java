package com.example.notification.service;

import com.example.notification.model.Notification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotificationService {
    private final List<Notification> history = new ArrayList<>();

    public Notification send(String channel, String recipient, String message) {
        String validationError = validate(channel, recipient, message);
        if (validationError != null) {
            Notification failedNotification = new Notification(channel, recipient, message, false, validationError);
            history.add(failedNotification);
            return failedNotification;
        }

        boolean delivered = deliver(channel, recipient, message);
        Notification notification = new Notification(
                channel,
                recipient,
                message,
                delivered,
                delivered ? null : "Delivery simulation failed"
        );

        history.add(notification);
        return notification;
    }

    private String validate(String channel, String recipient, String message) {
        if (channel == null || channel.isBlank()) {
            return "Channel cannot be empty";
        }
        if (recipient == null || recipient.isBlank()) {
            return "Recipient cannot be empty";
        }
        if (message == null || message.isBlank()) {
            return "Message cannot be empty";
        }

        String normalizedChannel = channel.trim().toUpperCase();
        switch (normalizedChannel) {
            case "EMAIL":
                if (!recipient.contains("@") || recipient.indexOf('@') >= recipient.lastIndexOf('.')) {
                    return "Invalid email address format";
                }
                break;
            case "SMS":
            case "WHATSAPP":
                if (!recipient.matches("^\\+?[0-9]{7,15}$")) {
                    return "Invalid phone number format (expected 7-15 digits with optional leading +)";
                }
                break;
            default:
                return "Unsupported notification channel: " + channel;
        }

        return null;
    }

    private boolean deliver(String channel, String recipient, String message) {
        String normalizedChannel = channel.trim().toUpperCase();
        switch (normalizedChannel) {
            case "EMAIL":
                System.out.printf("[EMAIL DISPATCHED] To: %s | Message: %s%n", recipient, message);
                return true;
            case "SMS":
                System.out.printf("[SMS DISPATCHED] To: %s | Message: %s%n", recipient, message);
                return true;
            case "WHATSAPP":
                System.out.printf("[WHATSAPP DISPATCHED] To: %s | Message: %s%n", recipient, message);
                return true;
            default:
                return false;
        }
    }

    public List<Notification> getHistory() {
        return Collections.unmodifiableList(history);
    }
}
