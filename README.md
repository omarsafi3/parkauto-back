# Car Park Management Application - Backend

Welcome to the Car Park Management Application backend. This application is designed to efficiently manage a fleet of vehicles, providing features such as maintenance scheduling, fuel management, insurance tracking, technical inspections, and user management.

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Features
- **Maintenance Management**: Schedule and track vehicle maintenance.
- **Fuel Management**: Monitor fuel consumption and optimize costs.
- **Insurance Tracking**: Keep track of insurance policies and their validity.
- **Technical Inspections**: Schedule and track technical inspections for compliance.
- **User Management**: Assign vehicles to users and manage user data.
- **Reporting and Analytics**: Generate detailed reports for performance analysis.

## Technologies
- **Java**: Programming language used for development.
- **Spring Boot**: Framework for building the application.
- **Hibernate**: ORM framework for database interaction.
- **Maven**: Build and dependency management tool.
- **Oracle Database**: Database for storing application data.

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven
- Oracle Database
- Git

### Installation
1. Clone the repository:
    ```sh
    git clone https://github.com/your-username/car-park-management-backend.git
    cd car-park-management-backend
    ```

2. Configure the database connection:
    Edit the `src/main/resources/application.properties` file with your database credentials:
    ```properties
    spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl
    spring.datasource.username=your-db-username
    spring.datasource.password=your-db-password
    spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

3. Build the project:
    ```sh
    mvn clean install
    ```

## Configuration
Configuration settings can be found in the `src/main/resources/application.properties` file. Adjust these settings according to your environment.

## Running the Application
To run the application, use the following command:
```sh
mvn spring-boot:run
```

Authentication

POST /api/auth/login: Authenticate a user.

Vehicles:

GET /api/vehicles: Get a list of all vehicles.

POST /api/vehicles: Add a new vehicle.

PUT /api/vehicles/{id}: Update a vehicle.

DELETE /api/vehicles/{id}: Delete a vehicle.

Users:

GET /api/users: Get a list of all users.

POST /api/users: Add a new user.

PUT /api/users/{id}: Update a user.

DELETE /api/users/{id}: Delete a user.

Maintenance:

GET /api/maintenance: Get a list of all maintenance records.

POST /api/maintenance: Add a new maintenance record.

PUT /api/maintenance/{id}: Update a maintenance record.

DELETE /api/maintenance/{id}: Delete a maintenance record.

Fuel:

GET /api/fuel: Get a list of all fuel records.
POST /api/fuel: Add a new fuel record.
PUT /api/fuel/{id}: Update a fuel record.
DELETE /api/fuel/{id}: Delete a fuel record.
