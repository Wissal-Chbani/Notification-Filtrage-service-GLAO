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

2. Configure Mongo Express credentials

   1. In the project root, create a file named `.env`.
   2. Add your Mongo Express username and password inside the `.env` file like this:
   ```bash
   ME_CONFIG_BASICAUTH_USERNAME=your_username
   ME_CONFIG_BASICAUTH_PASSWORD=your_password
   ```

3. Start the application using Docker Compose:

```bash
docker-compose up --build
```

This will start three containers:

- mongo → MongoDB database
- mongo-express → Web interface to browse MongoDB at http://localhost:8081
- notification-service → Spring Boot backend at http://localhost:8080