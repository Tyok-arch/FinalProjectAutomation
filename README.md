# Final Project Automation

![CI](https://github.com/Tyok-arch/FinalProjectAutomation/actions/workflows/automation.yml/badge.svg)

QA Automation Testing Project menggunakan **Selenium**, **RestAssured**, **GraphQL**, **Cucumber**, **JUnit**, dan **Maven**.

Project ini dibuat sebagai Final Project Software Quality Assurance untuk melakukan pengujian Manual Testing dan Automation Testing pada aplikasi web.

---

# Tech Stack

- Java 17
- Maven
- Selenium WebDriver
- RestAssured
- GraphQL
- Cucumber
- JUnit 4
- WebDriverManager

---

# Project Structure

```
src
├── main
│   └── java
│       └── automation
│           ├── driver
│           ├── locators
│           ├── pages
│           └── utils
│
└── test
    ├── java
    │   └── automation
    │       ├── api
    │       ├── hooks
    │       ├── runners
    │       └── stepdefinitions
    │
    └── resources
        └── features
```

---

# Features Tested

## UI Automation

- Login
- Employee
- Division
- Program
- Announcement
- Bootcamp
- Media Library

Built using:

- Selenium
- Cucumber
- Page Object Model

---

## API Automation

Automation API menggunakan RestAssured dan GraphQL.

Coverage:

- Login
- Employee CRUD
- Division CRUD
- Program CRUD
- Announcement CRUD
- Bootcamp CRUD
- Media Query

---

# Automation Flow

## UI

```
Feature
    ↓
Step Definition
    ↓
Page Object
    ↓
Locator
    ↓
Driver
    ↓
Browser
```

---

## API

```
CRUD Test
    ↓
Bodies
    ↓
BaseGraphQL
    ↓
Authentication
    ↓
GraphQL Server
```

---

# Design Pattern

Project menggunakan beberapa design pattern:

- Page Object Model (POM)
- Builder Pattern
- Base API Class
- Session Manager
- Reusable Utility

---

# Running Project

Clone repository

```bash
git clone https://github.com/Tyok-arch/FinalProjectAutomation.git
```

Masuk ke project

```bash
cd FinalProjectAutomation
```

Install dependency

```bash
mvn clean install
```

Menjalankan seluruh automation

```bash
mvn clean test
```

---

# Test Report

Setelah test selesai, report dapat dilihat pada folder:

```
target/
```

---

# CI/CD

Project menggunakan GitHub Actions untuk menjalankan automation secara otomatis pada setiap:

- Push
- Pull Request

Workflow akan:

- Build Project
- Execute Automation
- Generate Report

---

# Author

Theo

Final Project Software Quality Assurance
