package com.example.notification.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Module 1: Classes and Objects - Notification Tests")
class NotificationTest {

    @Test
    @DisplayName("Should initialize fields correctly when created using parameterized constructor")
    void shouldInitializeFieldsViaParameterizedConstructor() {
        Notification notification = new Notification("user@test.com", "Hello World", "EMAIL");

        assertEquals("user@test.com", notification.recipient);
        assertEquals("Hello World", notification.message);
        assertEquals("EMAIL", notification.channel);
    }

    @Test
    @DisplayName("Should allow instantiation via default constructor and subsequent field assignment")
    void shouldAllowDefaultConstructorAndFieldAssignment() {
        Notification notification = new Notification();

        assertNull(notification.recipient);
        assertNull(notification.message);
        assertNull(notification.channel);

        notification.recipient = "+1234567890";
        notification.message = "OTP: 1234";
        notification.channel = "SMS";

        assertEquals("+1234567890", notification.recipient);
        assertEquals("OTP: 1234", notification.message);
        assertEquals("SMS", notification.channel);
    }

    @Test
    @DisplayName("Should maintain independent state across distinct object instances")
    void shouldMaintainIndependentStateAcrossMultipleInstances() {
        Notification emailNotification = new Notification("alice@test.com", "Email 1", "EMAIL");
        Notification smsNotification = new Notification("+1987654321", "SMS 1", "SMS");

        // Mutating fields on one object should not impact the other object
        emailNotification.message = "Updated Email";

        assertEquals("Updated Email", emailNotification.message);
        assertEquals("SMS 1", smsNotification.message);
        assertNotEquals(emailNotification.recipient, smsNotification.recipient);
    }

    @Test
    @DisplayName("Should return accurate details string representing current state")
    void shouldReturnAccurateDetailsString() {
        Notification notification = new Notification("bob@test.com", "System Alert", "EMAIL");

        String details = notification.getDetails();

        assertTrue(details.contains("bob@test.com"));
        assertTrue(details.contains("System Alert"));
        assertTrue(details.contains("EMAIL"));
    }
}
