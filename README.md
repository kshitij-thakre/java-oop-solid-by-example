# Java OOP and SOLID Principles by Example

A practical, step-by-step educational Java project demonstrating **Object-Oriented Programming (OOP)** and the **5 SOLID Principles** using a realistic **Notification Management System**.

Built for learners and developers preparing for Java backend engineering technical interviews.

---

## 📌 Project Purpose

The primary goal of this repository is to bridge the gap between abstract software design definitions and real-world Java implementation. Instead of presenting isolated, sterile code snippets, this project evolves a simple notification system through 10 progressive modules—highlighting real problems, design trade-offs, refactoring strategies, and interview discussions.

---

## 🛠️ Prerequisites

- **Java JDK**: 17 or higher
- **Apache Maven**: 3.8 or higher
- Terminal / Shell environment

To verify your local environment:
```bash
java -version
mvn -version
```

---

## 🚀 How to Build, Test, and Run

### 1. Run Unit Tests
Executes all JUnit 5 test suites across all implemented modules:
```bash
mvn clean test
```

### 2. Package the Application
Compiles the code, runs tests, and packages an executable JAR:
```bash
mvn package
```

### 3. Run the Application
You can run the console application directly via Maven:
```bash
mvn compile exec:java
```

Or run the packaged JAR file:
```bash
java -jar target/java-oop-solid-by-example-1.0.0.jar
```

---

## 📂 Project Structure

```
java-oop-solid/
├── pom.xml                               # Maven build configuration (Java 17, JUnit 5)
├── README.md                             # Project overview and execution guide
├── .gitignore                            # Standard Java & Maven git ignore rules
├── docs/                                 # Educational guides and learning resources
│   ├── learning-roadmap.md               # 10-module evolution roadmap
│   └── oop-concepts.md                   # In-depth OOP theory & interview Q&A
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── example/
    │               └── notification/
    │                   ├── Main.java     # Interactive console driver
    │                   └── model/
    │                       └── Notification.java # Module 1: Core class blueprint
    └── test/
        └── java/
            └── com/
                └── example/
                    └── notification/
                        └── model/
                            └── NotificationTest.java # JUnit 5 test suite
```

---

## 📖 Learning Sequence & Curriculum

| Milestone | Module | Concept | Focus | Status |
|---|---|---|---|---|
| **Milestone 1** | **Module 1** | **Classes & Objects** | Blueprint vs instance, fields, methods, constructors, `new` keyword | **CURRENT** |
| Milestone 2 | Module 2 | Encapsulation | Private fields, validation invariants, getters/setters, risk of mutable state | Upcoming |
| Milestone 3 | Module 3 | Inheritance | `extends`, code reuse, method overriding, when inheritance is inappropriate | Upcoming |
| Milestone 4 | Module 4 | Abstraction | Abstract classes vs. interfaces, contract-driven programming | Upcoming |
| Milestone 5 | Module 5 | Polymorphism | Runtime dynamic dispatch, uniform references, interface programming | Upcoming |
| Milestone 6 | Module 6 | Single Responsibility (SRP) | Cohesive classes; separating validation, sending, and logging | Upcoming |
| Milestone 7 | Module 7 | Open/Closed (OCP) | Extensible design; eliminating switch/if-else logic on delivery channels | Upcoming |
| Milestone 8 | Module 8 | Liskov Substitution (LSP) | Behavioral subtyping; contract adherence without unexpected errors | Upcoming |
| Milestone 9 | Module 9 | Interface Segregation (ISP) | Avoiding fat interfaces; role-based client-specific interfaces | Upcoming |
| Milestone 10 | Module 10 | Dependency Inversion (DIP) | High-level modules depending on abstractions; constructor injection | Upcoming |

---

## 💻 Example Console Output (Module 1)

When running `mvn compile exec:java`:

```text
==================================================
 Java OOP & SOLID By Example: Module 1
 Topic: Classes, Objects, Fields, Methods & new
==================================================

--- 1. Creating Objects with 'new' and Parameterized Constructor ---

--- 2. Invoking Instance Methods (Behavior) ---
[EMAIL] Dispatching notification to 'student@example.com': Welcome to Java OOP and SOLID course!
[SMS] Dispatching notification to '+1-555-0199': Your verification code is 849201

--- 3. Verifying Independent Object State ---
Email Object State: Notification[channel=EMAIL, recipient=student@example.com, message='Welcome to Java OOP and SOLID course!']
SMS Object State:   Notification[channel=SMS, recipient=+1-555-0199, message='Your verification code is 849201']

--- 4. Creating an Object with Default Constructor ---
[WHATSAPP] Dispatching notification to '+1-555-0144': Hey! Your order has been delivered.
WhatsApp Object State: Notification[channel=WHATSAPP, recipient=+1-555-0144, message='Hey! Your order has been delivered.']

==================================================
 Notice how 'whatsAppNotification' fields were modified
 directly from outside the class. In Module 2, we will
 see why direct field access is risky and how Encapsulation
 protects our data with validation and controlled access.
==================================================
```

---

## 🧭 How to Navigate the Educational Modules

1. **Start with the Documentation**: Read [`docs/learning-roadmap.md`](file:///Users/kshitijthakre/Development/Java/java-oop-solid/docs/learning-roadmap.md) to understand the overarching system architecture.
2. **Review OOP Theory**: Study [`docs/oop-concepts.md`](file:///Users/kshitijthakre/Development/Java/java-oop-solid/docs/oop-concepts.md) for detailed explanations, diagrams, and interview questions.
3. **Inspect the Code**: Browse the code in [`src/main/java/com/example/notification/`](file:///Users/kshitijthakre/Development/Java/java-oop-solid/src/main/java/com/example/notification/).
4. **Execute Tests**: Run `mvn clean test` to observe unit tests validating design invariants.
5. **Discuss & Advance**: Review the design decisions and proceed sequentially to the next milestone.
