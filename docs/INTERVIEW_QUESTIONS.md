# Backend Developer Interview Questions & Answers

These questions are based on the actual design decisions made in our Notification Management System.

---

### Q1: Why is the `Notification` model class immutable?
**Answer**:
In our system, a [`Notification`](file:///Users/kshitijthakre/Development/Java/java-oop-solid/src/main/java/com/example/notification/model/Notification.java) instance represents an audit record of an event that has already occurred. Making its fields `private` and `final` guarantees that:
1. The status or payload cannot be tampered with after instantiation.
2. The object is inherently thread-safe without requiring synchronization.
3. History logs maintain referential integrity.

---

### Q2: Why did `NotificationService.getHistory()` return `Collections.unmodifiableList(history)` instead of returning `history` directly?
**Answer**:
Returning a direct reference to a private mutable collection breaks encapsulation. External callers could modify the list (e.g., calling `.clear()` or removing elements), corrupting the service's internal state. `Collections.unmodifiableList` provides an unmodifiable view, ensuring that only the service can append to the history.

---

### Q3: What is the main drawback of using `switch (channel)` in `NotificationService`?
**Answer**:
The `switch` statement couples the service directly to every known channel and violates the **Open/Closed Principle (OCP)**:
1. Every time a new channel is added, `NotificationService` must be modified and retested.
2. The class grows larger with each channel, increasing the likelihood of merge conflicts and regressions.
3. The preferred OOP alternative is polymorphism: delegating delivery to an interface (`NotificationSender`) implemented by each specific channel.

---

### Q4: How does validation tie into Encapsulation?
**Answer**:
Encapsulation is not just about making fields `private` and adding getters/setters. It is about protecting **class invariants**—rules that must always remain true for an object to be valid. In our application, validation ensures that an invalid recipient or message is caught before dispatch, preventing the system from entering an undefined state.

---

### Q5: How would you unit test `NotificationService` if it used real third-party APIs (like SendGrid or Twilio) instead of console simulation?
**Answer**:
By applying the **Dependency Inversion Principle (DIP)**:
1. Extract the sending mechanism into an interface (`NotificationSender`).
2. Pass the interface into `NotificationService` via constructor injection.
3. In unit tests, inject a mock or test double that implements `NotificationSender`, allowing tests to run quickly, reliably, and without incurring third-party API costs or network dependencies.
