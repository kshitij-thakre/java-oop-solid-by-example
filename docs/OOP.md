# Object-Oriented Programming (OOP) in the Notification System

This document explains OOP concepts directly through the code implemented in Phase 1.

---

## 1. Classes and Objects

### What Is a Class?
A class is a blueprint that defines state and behavior.
- In our application, [`Notification`](file:///Users/kshitijthakre/Development/Java/java-oop-solid/src/main/java/com/example/notification/model/Notification.java) defines what a notification record contains: channel, recipient, message, timestamp, and delivery status.
- [`NotificationService`](file:///Users/kshitijthakre/Development/Java/java-oop-solid/src/main/java/com/example/notification/service/NotificationService.java) defines the operations for validating, dispatching, and storing notifications.

### What Is an Object?
An object is a concrete instance of a class allocated in memory.
- When a user sends an email to `alice@example.com`, `new Notification(...)` creates a unique object in heap memory representing that specific event.
- If the user sends a second message, a second independent `Notification` object is created. Modifying or inspecting one object has no effect on the other.

---

## 2. Encapsulation

Encapsulation bundles data with the methods that operate on that data and restricts direct access to an object's internal components.

### Implementation in `Notification`
```java
public class Notification {
    private final String channel;
    private final String recipient;
    private final String message;
    private final LocalDateTime timestamp;
    private final boolean successful;
    private final String failureReason;
    ...
}
```

#### Why are fields marked `private` and `final`?
1. **Invariant Protection**: External code cannot alter `successful` to `true` on a notification that actually failed.
2. **Immutability**: Once created, a notification represents a historical record of an event that already took place. It should never change.
3. **Controlled Access**: Callers read attributes through getters (`getRecipient()`, `isSuccessful()`), preserving the class's internal integrity.

### Encapsulation in `NotificationService`
```java
public class NotificationService {
    private final List<Notification> history = new ArrayList<>();

    public List<Notification> getHistory() {
        return Collections.unmodifiableList(history);
    }
}
```
If `history` were `public`, external code could do `service.history.clear()` or add fake notifications without going through `send()`.
Returning `Collections.unmodifiableList(history)` ensures callers can inspect the list, but cannot mutate it directly.

---

## 3. Current Limitations: Abstraction and Polymorphism

In the Phase 1 implementation, delivery and validation use conditional branches:
```java
switch (normalizedChannel) {
    case "EMAIL":
        ...
    case "SMS":
        ...
    case "WHATSAPP":
        ...
}
```

### The Problem With This Approach:
- Whenever a new channel (e.g., Slack or Push Notification) is introduced, `NotificationService` must be modified in multiple places (validation, delivery).
- As channels grow, `NotificationService` becomes bloated.

### The OOP Solution (Coming in Phase 2 & 3):
- **Abstraction**: Define a common contract (`NotificationSender`) with a method `send(Notification notification)`.
- **Polymorphism**: Allow `NotificationService` to work with any object implementing that contract, replacing `switch` statements with dynamic dispatch.
