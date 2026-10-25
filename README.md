# Java OOP & SOLID by Example

A practical, simple Java console application demonstrating Object-Oriented Programming (OOP) and SOLID principles through real design decisions.

---

## 📌 Project Purpose

Rather than memorizing abstract definitions, this project uses a working **Notification Management System** to illustrate:
1. Why classes and methods are structured in a specific way.
2. What problems occur in an initial procedural/monolithic design.
3. How applying OOP concepts and SOLID principles solves real design problems without overengineering.

---

## 🛠️ Prerequisites

- **Java JDK**: 17 or higher
- **Apache Maven**: 3.8 or higher

Verify your installation:
```bash
java -version
mvn -version
```

---

## 🚀 Build, Test, and Run

### Run Unit Tests
```bash
mvn clean test
```

### Run the Interactive Application
```bash
mvn compile exec:java
```

### Package and Run Executable JAR
```bash
mvn package
java -jar target/java-oop-solid-by-example-1.0.0.jar
```

---

## 📂 Project Structure

```
java-oop-solid-by-example/
├── pom.xml                                  # Java 17 and JUnit 5 Maven configuration
├── README.md                                # Setup, execution, and project overview
├── docs/
│   ├── OOP.md                               # OOP concepts mapped to actual code
│   ├── SOLID.md                             # SOLID problems, trade-offs, and solutions
│   └── INTERVIEW_QUESTIONS.md               # Technical interview Q&A
└── src/
    ├── main/java/com/example/notification/
    │   ├── Main.java                        # Console UI and user interaction
    │   ├── model/
    │   │   └── Notification.java            # Immutable notification record
    │   └── service/
    │       └── NotificationService.java     # Notification flow, validation, and history
    └── test/java/com/example/notification/
        └── service/
            └── NotificationServiceTest.java # JUnit 5 test suite
```

---

## 🧭 Incremental Development Phases

- **Phase 1 (Current)**: Working notification flow supporting Email, SMS, and WhatsApp with input validation, console dispatch, and history tracking.
- **Phase 2**: OOP design review (Encapsulation, Abstraction, Polymorphism).
- **Phase 3**: Progressive SOLID refactoring (SRP, OCP, LSP, ISP, DIP).
- **Phase 4**: Expanded test suite and finalized documentation.
