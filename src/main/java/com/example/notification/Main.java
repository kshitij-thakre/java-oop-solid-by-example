package com.example.notification;

import com.example.notification.model.Notification;
import com.example.notification.service.NotificationService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Notification Management System ===");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Send Notification");
            System.out.println("2. View Notification History");
            System.out.println("3. Exit");
            System.out.print("Enter choice (1-3): ");

            if (!scanner.hasNextLine()) {
                break;
            }

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    handleSendNotification(service, scanner);
                    break;
                case "2":
                    handleViewHistory(service);
                    break;
                case "3":
                    System.out.println("Exiting application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    private static void handleSendNotification(NotificationService service, Scanner scanner) {
        System.out.println("\nSelect Channel:");
        System.out.println("1. Email");
        System.out.println("2. SMS");
        System.out.println("3. WhatsApp");
        System.out.print("Enter channel (1-3): ");

        if (!scanner.hasNextLine()) {
            return;
        }

        String channelChoice = scanner.nextLine().trim();
        String channel;
        switch (channelChoice) {
            case "1":
                channel = "EMAIL";
                break;
            case "2":
                channel = "SMS";
                break;
            case "3":
                channel = "WHATSAPP";
                break;
            default:
                System.out.println("Invalid channel choice.");
                return;
        }

        System.out.print("Enter recipient: ");
        if (!scanner.hasNextLine()) {
            return;
        }
        String recipient = scanner.nextLine().trim();

        System.out.print("Enter message: ");
        if (!scanner.hasNextLine()) {
            return;
        }
        String message = scanner.nextLine().trim();

        System.out.println("\nSending notification...");
        Notification result = service.send(channel, recipient, message);

        if (result.isSuccessful()) {
            System.out.println("Result: SUCCESS");
        } else {
            System.out.println("Result: FAILED - " + result.getFailureReason());
        }
    }

    private static void handleViewHistory(NotificationService service) {
        System.out.println("\n--- Notification History ---");
        List<Notification> history = service.getHistory();
        if (history.isEmpty()) {
            System.out.println("No notifications recorded yet.");
            return;
        }

        for (int i = 0; i < history.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, history.get(i));
        }
    }
}
