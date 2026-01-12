# Loan Approval Microservices Platform

An end-to-end Spring Cloud microservices system for automated loan / proposal approval workflows, including submission, review, notification, and status tracking. The system is built with Spring Cloud, Eureka, Gateway, Kafka, MySQL, and Docker, and supports containerized deployment.

---

## Features

- Microservices-based architecture with clear service boundaries
- Service discovery using Eureka
- API Gateway for unified routing and access control
- Event-driven communication using Kafka
- MySQL persistence for business data
- Docker Compose for one-click local deployment
- Supports:
    - Proposal submission
    - Approval workflow processing
    - User management
    - Notification service
    - Status tracking

---

## Architecture

```
Client
   |
   v
[ API Gateway ]
   |
   v
[ Eureka Service Registry ]
   |
   +-----------------------------+
   |            |               |
   v            v               v
[ User ]   [ Approval ]   [ Notification ]
   |
   v
[ MySQL ]        [ Kafka Event Bus ]
```

---

## Tech Stack

- Backend: Java, Spring Boot, Spring Cloud
- Service Discovery: Eureka
- API Gateway: Spring Cloud Gateway
- Messaging: Kafka
- Database: MySQL
- Containerization: Docker, Docker Compose
- Build Tool: Maven

---

## Project Structure

```
proposal-management-cloud/
├── proposal-eureka-server/        # Service registry
├── proposal-gateway/              # API gateway
├── proposal-user-service/         # User service
├── proposal-approval-service/     # Approval workflow service
├── proposal-notification-service/ # Notification service
├── docker-compose.yml             # One-click startup for all services
├── pom.xml                        # Parent Maven config
└── README.md
```

---

## Workflow

1. User submits a proposal
2. Approval service processes the workflow
3. Events are published via Kafka
4. Notification service consumes events and sends notifications
5. Status is persisted in MySQL and queryable via API

---

## How to Run (Local)

### Prerequisites

- Java 17+
- Maven
- Docker & Docker Compose

---

### Build all services

```bash
mvn clean package -DskipTests
```

---

### Start all services

```bash
docker-compose up
```

---

### Access

- Eureka Dashboard:
  http://localhost:8761

- API Gateway:
  http://localhost:8080

---

## Design Highlights

- Follows microservices best practices
- Event-driven architecture using Kafka
- Clear separation of concerns between services
- Easy to scale and extend individual services
- Production-style infrastructure layout

---

## Use Case

This project is intended as:

- A portfolio project demonstrating:
    - Microservices architecture design
    - Distributed system integration
    - Backend system engineering
- A reference implementation for:
    - Spring Cloud ecosystem
    - Event-driven backend systems

