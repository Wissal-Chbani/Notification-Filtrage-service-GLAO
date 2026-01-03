                                    # Notification Service

This project is a Spring Boot backend application for managing notifications. It uses MongoDB for storage and comes with a Docker setup for easy testing.

## Requirements

- Docker
- Docker Compose
- Java 17 (only if you want to build locally without Docker)

## Quick Start with Docker

1. Clone the repository:

```bash
git clone https://github.com/Wissal-Chbani/Notification-Filtrage-service-GLAO
cd Notification-Filtrage-service-GLAO
```
2. Start the application using Docker Compose:

```bash
Start the application using Docker Compose:
```

This will start three containers:

- mongo → MongoDB database
- mongo-express → Web interface to browse MongoDB at http://localhost:8081
- notification-service → Spring Boot backend at http://localhost:8080