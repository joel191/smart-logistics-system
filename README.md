# Smart Logistics & Order Management System (Backend)

A production-ready backend system built using **Java 17 and Spring Boot**, featuring **JWT-based authentication**, **role-based authorization**, **PostgreSQL persistence**, **Swagger API documentation**, and **Dockerized deployment**.

This project is designed as an **industry-style backend capstone** to demonstrate real-world backend engineering practices.

---

## 🚀 Tech Stack

- Java 17  
- Spring Boot  
- Spring Security  
- JWT (JSON Web Token)  
- PostgreSQL  
- JPA / Hibernate  
- Swagger / OpenAPI  
- Docker & Docker Compose  
- Maven  

---

## ✨ Features

- Role-based users: **ADMIN, CUSTOMER, DELIVERY_PARTNER**
- Secure authentication using **JWT**
- Password encryption with **BCrypt**
- Role-based API authorization
- RESTful API design
- Swagger UI for API documentation and testing
- Dockerized application with PostgreSQL
- Health check endpoint for container monitoring

---

## 🧱 Architecture

The application follows a clean layered architecture:

- **Controller Layer** – Handles HTTP requests
- **Service Layer** – Contains business logic
- **Repository Layer** – Database access using JPA
- **DTOs** – Request/response validation
- **Security Layer** – JWT authentication and authorization filter

---

## 🔐 Security

- Stateless authentication using JWT
- Passwords stored using BCrypt hashing
- Role-based access control with Spring Security
- Public access only for authentication, Swagger, and health endpoints

---

## 📘 API Documentation (Swagger)

Once the application is running, access Swagger UI:

http://localhost:8085/swagger-ui/index.html


Swagger allows interactive testing of all available APIs.

---

## 🐳 Docker Setup

Run the complete application (Backend + PostgreSQL) using Docker Compose:


docker compose up --build
---
## Services:

Backend API: http://localhost:8085

Swagger UI: http://localhost:8085/swagger-ui/index.html

Health Check: http://localhost:8085/actuator/health
---
## To stop containers:

docker compose down
---
## Key API Endpoints:

POST /api/auth/login – User login and JWT generation

POST /api/users – Create user (ADMIN only)
---
## AUTHOR :

ALIGI JOEL
