HEAD
[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-2e0aaae1b6195c2367325f4f02e2d04e9abb55f0b24a779b69b11b9e10269abc.svg)](https://classroom.github.com/online_ide?assignment_repo_id=24000847&assignment_repo_type=AssignmentRepo)
# Merchant-order-desk-and-catalogue-engine

PayNest

This project simulates a commerce backend where merchants can create products, accepts customer orders, and process payments.

---
How to Run the Project

Prerequisites

Java 21
Maven 3.6+

---

Build and Run

Compile the project
mvn compile

Run unit tests
mvn test

Run the application
mvn exec:java

---

Expected Output

Order summary

---

Order ID: 1
Customer: Claudelle Francis
Email: claudelle.francis@umuzi.org

---

Items:
 - Monitor | x1 | R6000
 - Wireless Mouse | x2 | R400
========================
Total: R6400
========================

---

# 📁 Project Structure

MERCHANT-ORDER-DESK-AND-CATALOGUE-ENGINE/
├── .github/
├── .vscode/
├── src/
│   ├── main/java/
│   │   ├── app/
│   │   │   └── PayNestApplication.java
│   │   ├── domain/
│   │   │   ├── Customer.java
│   │   │   ├── Order.java
│   │   │   ├── OrderItem.java
│   │   │   └── Product.java
│   │   └── service/
│   │       └── OrderService.java
│   │
│   └── test/java/
│       ├── domain/
│       │   ├── OrderItemTest.java
│       │   ├── OrderItemValidationTest.java
│       │   └── OrderTest.java
│       └── service/
│           └── OrderServiceTest.java
│
├── target/
│   ├── classes/
│   ├── generated-sources/
│   ├── generated-test-sources/
│   ├── maven-status/
│   ├── surefire-reports/
│   └── test-classes/
│
├── pom.xml
└── README.md

---


Package Overview

| Package | Description |
|----------|-------------|
| `app` | Contains the application entry point (`PayNestApplication`). |
| `domain` | Contains core business entities such as `Customer`, `Order`, `OrderItem`, and `Product`. |
| `service` | Contains business logic and service-layer functionality. |
| `test/java` | Contains unit and validation tests for domain and service classes. |
| `target` | Maven-generated build artifacts and test reports. | aa9808f (edited files and completed Capstone 1)
