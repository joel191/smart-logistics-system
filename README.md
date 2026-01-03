# 📦 Smart Logistics & Order Management System

A **production-style backend application** that simulates real-world logistics workflows (Swiggy / Zomato–like) with **secure authentication**, **role-based authorization**, and a **strict order lifecycle**.

This project is built as an **industry-ready backend capstone** using Java and Spring Boot.

---

## 🚀 Features

### 🔐 Authentication & Authorization
- JWT-based authentication
- Secure user registration and login
- Role-based access control

### 👥 User Roles
- **CUSTOMER** – places orders
- **DELIVERY_PARTNER** – picks assigned orders
- **ADMIN** – manages and completes orders

### 📦 Order Lifecycle Management
Orders follow a strict lifecycle:

CREATED → ASSIGNED → PICKED → DELIVERED

Invalid state transitions are blocked using service-layer business rules.

### 🛡 Global Exception Handling
- Centralized exception handling with `@RestControllerAdvice`
- Clean and consistent API error responses
- No raw stack traces exposed to clients

### 📑 API Documentation
- Swagger / OpenAPI integration
- JWT authentication supported directly in Swagger UI

---

## 🛠 Tech Stack

| Layer | Technology |
|-----|-----------|
| Language | Java 17 |
| Framework | Spring Boot 3 |
| Security | Spring Security + JWT |
| Database | PostgreSQL |
| ORM | Spring Data JPA (Hibernate) |
| API Docs | Swagger / OpenAPI |
| Build Tool | Maven |
| Containerization | Docker |

---

## 🔐 Authentication Flow

1. User registers using `POST /api/users`
2. User logs in using `POST /api/auth/login`
3. Server returns a **JWT token**
4. Token is sent in request headers:
   Authorization: Bearer <JWT_TOKEN>
5. Role-based access is enforced for APIs

---

## 📦 Order APIs Overview

| API Endpoint | Role | Description |
|--------------|------|------------|
| `POST /api/orders` | CUSTOMER | Create a new order |
| `PUT /api/orders/{id}/assign` | ADMIN | Assign order |
| `PUT /api/orders/{id}/status` | DELIVERY_PARTNER | Pick order |
| `PUT /api/orders/{id}/status` | ADMIN | Deliver order |
| `GET /api/orders` | ALL | View orders (role-based) |

---

## 🧪 API Documentation (Swagger)

After starting the application, open:

http://localhost:8085/swagger-ui/index.html


Swagger supports:
- JWT Authorize button
- Full API testing
- Role-based access validation

---

## 🗄 Database Design (High-Level)

### Users Table
- id
- name
- email
- password (BCrypt encrypted)
- role

### Orders Table
- id
- customer_id
- total_amount
- status

---

## 🐳 Docker Support

The application is Docker-ready for consistent deployment.

### Build & Run
```bash
docker-compose up --build
```
----

### Key Backend Concepts Implemented

JWT authentication and authorization

Role-based access control

Service-layer business logic

Order lifecycle enforcement

Global exception handling

RESTful API design

Swagger / OpenAPI documentation

Dockerized backend


