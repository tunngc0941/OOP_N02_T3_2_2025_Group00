# Spring Boot Shoe Management Web Application

This project is a Spring Boot web application for managing shoes, featuring a Graphic User Interface (GUI) built with Thymeleaf.

## Features
- Manage products (shoes) with CRUD operations
- Manage customers and transactions
- Web-based GUI using Thymeleaf
- Easily extendable for additional entities (e.g., customers, orders)

## Getting Started
1. Ensure you have Java and Maven installed.
2. Build and run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Open your browser and go to `http://localhost:8080`

## Project Structure
- `src/main/java` - Java source code
- `src/main/resources/templates` - Thymeleaf HTML templates
- `src/main/resources/static` - Static resources (CSS, JS)

## Customization
You can extend this project by adding new entities and views as needed.

---

This project was generated using [Spring Initializr](https://start.spring.io/) with Web and Thymeleaf dependencies.
