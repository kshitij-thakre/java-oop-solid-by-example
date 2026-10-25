# SOLID Principles: Design Problems and Architectural Evolution

This document analyzes the design trade-offs of the initial Phase 1 codebase and outlines the concrete improvements targeted for Phase 3.

---

## 1. Single Responsibility Principle (SRP)
> *"A class should have one, and only one, reason to change."*

### Current Design in Phase 1:
[`NotificationService`](file:///Users/kshitijthakre/Development/Java/java-oop-solid/src/main/java/com/example/notification/service/NotificationService.java) currently handles three separate responsibilities:
1. **Validation**: Validating email and phone number formats.
2. **Delivery**: Executing channel-specific dispatch logic.
3. **History**: Managing the in-memory log of notification events.

### The Problem:
`NotificationService` has three distinct reasons to change:
- If validation rules become more strict, `NotificationService` changes.
- If delivery mechanics change, `NotificationService` changes.
- If history storage changes (e.g., limits, persistence), `NotificationService` changes.

### Planned Improvement:
Extract validation and history management into distinct classes so each class has a single, cohesive reason to change.

---

## 2. Open/Closed Principle (OCP)
> *"Software entities should be open for extension, but closed for modification."*

### Current Design in Phase 1:
```java
switch (normalizedChannel) {
    case "EMAIL": ...
    case "SMS": ...
    case "WHATSAPP": ...
}
```

### The Problem:
To add a 4th channel (such as Slack), we must open `NotificationService.java` and modify both the `validate()` and `deliver()` methods. Every modification to an existing class risks introducing regressions into already working channels.

### Planned Improvement:
Introduce a `NotificationSender` abstraction. Adding a new channel will mean adding a new class (e.g., `SlackNotificationSender`) without changing a single line of existing delivery code.

---

## 3. Liskov Substitution Principle (LSP)
> *"Subtypes must be substitutable for their base types without altering program correctness."*

### The Design Challenge:
When we introduce a `NotificationSender` interface, any implementation (Email, SMS, WhatsApp) must honor the contract. If an SMS sender throws an `UnsupportedOperationException` when called, or requires secret prerequisites not defined in the contract, it violates LSP.

### Planned Improvement:
Ensure all senders implement the contract uniformly and handle channel-specific details without breaking client expectations.

---

## 4. Interface Segregation Principle (ISP)
> *"Clients should not be forced to depend on methods they do not use."*

### The Design Challenge:
If we create an interface with methods like `sendText()`, `sendWithAttachment()`, and `sendVoiceNote()`, an `SmsNotificationSender` would be forced to implement attachment methods that SMS does not support.

### Planned Improvement:
Keep the core delivery contract minimal and focused. Additional capabilities (like attachments) will use dedicated, segregated interfaces.

---

## 5. Dependency Inversion Principle (DIP)
> *"High-level modules should not depend on low-level modules. Both should depend on abstractions."*

### Current Design in Phase 1:
`NotificationService` directly controls the low-level delivery mechanics.

### Planned Improvement:
`NotificationService` will receive a collection or registry of `NotificationSender` abstractions via constructor injection. This decouples the service from concrete implementations and allows unit tests to pass mock senders effortlessly.
