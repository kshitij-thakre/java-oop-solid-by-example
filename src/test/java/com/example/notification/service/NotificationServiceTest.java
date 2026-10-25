package com.example.notification.service;

import com.example.notification.model.Notification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {

    private NotificationService service;

    @BeforeEach
    void setUp() {
        service = new NotificationService();
    }

    @Test
    void shouldSendEmailSuccessfullyWhenInputIsValid() {
        Notification result = service.send("EMAIL", "alice@example.com", "Your order has shipped.");

        assertTrue(result.isSuccessful());
        assertNull(result.getFailureReason());
        assertEquals("EMAIL", result.getChannel());
        assertEquals("alice@example.com", result.getRecipient());
        assertEquals("Your order has shipped.", result.getMessage());
        assertNotNull(result.getTimestamp());
    }

    @Test
    void shouldSendSmsSuccessfullyWhenInputIsValid() {
        Notification result = service.send("SMS", "+15551234567", "Your OTP is 928374.");

        assertTrue(result.isSuccessful());
        assertNull(result.getFailureReason());
        assertEquals("SMS", result.getChannel());
        assertEquals("+15551234567", result.getRecipient());
    }

    @Test
    void shouldSendWhatsAppSuccessfullyWhenInputIsValid() {
        Notification result = service.send("WHATSAPP", "+15559876543", "Appointment confirmed for 3 PM.");

        assertTrue(result.isSuccessful());
        assertNull(result.getFailureReason());
        assertEquals("WHATSAPP", result.getChannel());
    }

    @Test
    void shouldFailWhenRecipientIsBlank() {
        Notification result = service.send("EMAIL", "   ", "Hello");

        assertFalse(result.isSuccessful());
        assertEquals("Recipient cannot be empty", result.getFailureReason());
    }

    @Test
    void shouldFailWhenMessageIsBlank() {
        Notification result = service.send("EMAIL", "bob@example.com", "");

        assertFalse(result.isSuccessful());
        assertEquals("Message cannot be empty", result.getFailureReason());
    }

    @Test
    void shouldFailWhenEmailFormatIsInvalid() {
        Notification result = service.send("EMAIL", "not-an-email", "Hello");

        assertFalse(result.isSuccessful());
        assertEquals("Invalid email address format", result.getFailureReason());
    }

    @Test
    void shouldFailWhenPhoneFormatIsInvalidForSms() {
        Notification result = service.send("SMS", "abc-phone", "Hello");

        assertFalse(result.isSuccessful());
        assertTrue(result.getFailureReason().contains("Invalid phone number format"));
    }

    @Test
    void shouldFailWhenChannelIsUnsupported() {
        Notification result = service.send("PAGER", "+15551234567", "Hello");

        assertFalse(result.isSuccessful());
        assertTrue(result.getFailureReason().contains("Unsupported notification channel"));
    }

    @Test
    void shouldRecordAllAttemptsInHistory() {
        service.send("EMAIL", "user@example.com", "First message");
        service.send("EMAIL", "invalid-email", "Second message");
        service.send("SMS", "+15551234567", "Third message");

        List<Notification> history = service.getHistory();

        assertEquals(3, history.size());
        assertTrue(history.get(0).isSuccessful());
        assertFalse(history.get(1).isSuccessful());
        assertTrue(history.get(2).isSuccessful());
    }
}
