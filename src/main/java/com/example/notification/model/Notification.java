package com.example.notification.model;

/**
 * Module 1: Classes and Objects
 *
 * What is a Class?
 * A class is a blueprint, template, or user-defined data type that defines
 * the state (fields) and behavior (methods) that objects created from it will possess.
 *
 * What is an Object?
 * An object is a concrete instance of a class created in heap memory using the 'new' keyword.
 * Each object maintains its own distinct copy of instance fields.
 */
public class Notification {

    // Fields: Represent the state (data) of a Notification object.
    // In this introductory module, fields are left directly accessible
    // so we can observe how fields hold state before we introduce Encapsulation in Module 2.
    public String recipient;
    public String message;
    public String channel;

    /**
     * Default (no-argument) Constructor.
     * Demonstrates that an object can be instantiated before its fields are populated.
     */
    public Notification() {
    }

    /**
     * Parameterized Constructor.
     * Used to initialize an object's fields at the moment of instantiation.
     *
     * @param recipient The destination (e.g., email address or phone number)
     * @param message   The message payload
     * @param channel   The delivery channel (e.g., EMAIL, SMS, WHATSAPP)
     */
    public Notification(String recipient, String message, String channel) {
        this.recipient = recipient;
        this.message = message;
        this.channel = channel;
    }

    /**
     * Method: Defines the behavior of the Notification object.
     * Operates on the internal state (recipient, message, channel) of the instance.
     */
    public void send() {
        System.out.printf("[%s] Dispatching notification to '%s': %s%n",
                channel != null ? channel : "UNKNOWN",
                recipient != null ? recipient : "<No Recipient>",
                message != null ? message : "<Empty Message>");
    }

    /**
     * Method: Provides a formatted string showing the object's current state.
     *
     * @return Formatted state of this object
     */
    public String getDetails() {
        return String.format("Notification[channel=%s, recipient=%s, message='%s']",
                channel, recipient, message);
    }
}
