package com.example.notification;

import com.example.notification.model.Notification;

/**
 * Main application entry point.
 *
 * Demonstrates Module 1: Classes and Objects in action.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Java OOP & SOLID By Example: Module 1");
        System.out.println(" Topic: Classes, Objects, Fields, Methods & new");
        System.out.println("==================================================\n");

        // 1. Instantiating objects using the 'new' keyword and a parameterized constructor
        System.out.println("--- 1. Creating Objects with 'new' and Parameterized Constructor ---");
        Notification emailNotification = new Notification(
                "student@example.com",
                "Welcome to Java OOP and SOLID course!",
                "EMAIL"
        );

        Notification smsNotification = new Notification(
                "+1-555-0199",
                "Your verification code is 849201",
                "SMS"
        );

        // 2. Invoking instance methods (Behavior)
        System.out.println("\n--- 2. Invoking Instance Methods (Behavior) ---");
        emailNotification.send();
        smsNotification.send();

        // 3. Demonstrating that objects maintain independent state in heap memory
        System.out.println("\n--- 3. Verifying Independent Object State ---");
        System.out.println("Email Object State: " + emailNotification.getDetails());
        System.out.println("SMS Object State:   " + smsNotification.getDetails());

        // 4. Using the default constructor and setting fields directly
        System.out.println("\n--- 4. Creating an Object with Default Constructor ---");
        Notification whatsAppNotification = new Notification();
        whatsAppNotification.recipient = "+1-555-0144";
        whatsAppNotification.message = "Hey! Your order has been delivered.";
        whatsAppNotification.channel = "WHATSAPP";

        whatsAppNotification.send();
        System.out.println("WhatsApp Object State: " + whatsAppNotification.getDetails());

        System.out.println("\n==================================================");
        System.out.println(" Notice how 'whatsAppNotification' fields were modified");
        System.out.println(" directly from outside the class. In Module 2, we will");
        System.out.println(" see why direct field access is risky and how Encapsulation");
        System.out.println(" protects our data with validation and controlled access.");
        System.out.println("==================================================");
    }
}
