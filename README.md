# Car Park Management Application - Backend

Welcome to the Car Park Management Application backend. This application is designed to efficiently manage a fleet of vehicles, providing features such as maintenance scheduling, fuel management, insurance tracking, technical inspections, and user management.

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
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
    git clone https://github.com/omarsafi3/parkauto-back.git
    cd /parkauto-back
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

## API Endpoints

### Authentication

- **POST /api/auth/login**: Authenticate a user.

### Vehicles

- **GET /api/vehicles**: Get a list of all vehicles.
- **POST /api/vehicles**: Add a new vehicle.
- **PUT /api/vehicles/{id}**: Update a vehicle.
- **DELETE /api/vehicles/{id}**: Delete a vehicle.

### Users

- **GET /api/users**: Get a list of all users.
- **POST /api/users**: Add a new user.
- **PUT /api/users/{id}**: Update a user.
- **DELETE /api/users/{id}**: Delete a user.

### Maintenance

- **GET /api/maintenance**: Get a list of all maintenance records.
- **POST /api/maintenance**: Add a new maintenance record.
- **PUT /api/maintenance/{id}**: Update a maintenance record.
- **DELETE /api/maintenance/{id}**: Delete a maintenance record.

### Assurance

- **GET /api/assurance**: Get a list of all assurance records.
- **POST /api/assurance**: Add a new assurance record.
- **PUT /api/assurance/{id}**: Update an assurance record.
- **DELETE /api/assurance/{id}**: Delete an assurance record.

### Beneficiaires

- **GET /api/beneficiaires**: Get a list of all beneficiaires.
- **POST /api/beneficiaires**: Add a new beneficiaire.
- **PUT /api/beneficiaires/{id}**: Update a beneficiaire.
- **DELETE /api/beneficiaires/{id}**: Delete a beneficiaire.

### Carburant

- **GET /api/carburant**: Get a list of all carburant records.
- **POST /api/carburant**: Add a new carburant record.
- **PUT /api/carburant/{id}**: Update a carburant record.
- **DELETE /api/carburant/{id}**: Delete a carburant record.

### Cartes

- **GET /api/cartes**: Get a list of all cartes.
- **POST /api/cartes**: Add a new carte.
- **PUT /api/cartes/{id}**: Update a carte.
- **DELETE /api/cartes/{id}**: Delete a carte.

### Contrat

- **GET /api/contrat**: Get a list of all contrats.
- **POST /api/contrat**: Add a new contrat.
- **PUT /api/contrat/{id}**: Update a contrat.
- **DELETE /api/contrat/{id}**: Delete a contrat.

### Fonction

- **GET /api/fonction**: Get a list of all fonctions.
- **POST /api/fonction**: Add a new fonction.
- **PUT /api/fonction/{id}**: Update a fonction.
- **DELETE /api/fonction/{id}**: Delete a fonction.

### Historique

- **GET /api/historique**: Get a list of all historique records.
- **POST /api/historique**: Add a new historique record.
- **PUT /api/historique/{id}**: Update a historique record.
- **DELETE /api/historique/{id}**: Delete a historique record.

### Ordre de Mission

- **GET /api/ordre-de-mission**: Get a list of all ordre de mission records.
- **POST /api/ordre-de-mission**: Add a new ordre de mission record.
- **PUT /api/ordre-de-mission/{id}**: Update an ordre de mission record.
- **DELETE /api/ordre-de-mission/{id}**: Delete an ordre de mission record.

### Ports

- **GET /api/ports**: Get a list of all ports.
- **POST /api/ports**: Add a new port.
- **PUT /api/ports/{id}**: Update a port.
- **DELETE /api/ports/{id}**: Delete a port.

### Transactions

- **GET /api/transactions**: Get a list of all transactions.
- **POST /api/transactions**: Add a new transaction.
- **PUT /api/transactions/{id}**: Update a transaction.
- **DELETE /api/transactions/{id}**: Delete a transaction.

### Vignette

- **GET /api/vignette**: Get a list of all vignette records.
- **POST /api/vignette**: Add a new vignette record.
- **PUT /api/vignette/{id}**: Update a vignette record.
- **DELETE /api/vignette/{id}**: Delete a vignette record.

### Visite Technique

- **GET /api/visite-technique**: Get a list of all visite technique records.
- **POST /api/visite-technique**: Add a new visite technique record.
- **PUT /api/visite-technique/{id}**: Update a visite technique record.
- **DELETE /api/visite-technique/{id}**: Delete a visite technique record.


## License

This project is licensed under the MIT License. See the LICENSE file for more details.

## Contact

For any inquiries or feedback, please contact:

Name: [Omar Safi]

Email: [safiomar.2003@gmail.com](mailto:safiomar.2003@gmail.com)

LinkedIn: [LinkedIn Profile](https://www.linkedin.com/in/omar-safi-583506284/)
