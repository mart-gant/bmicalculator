# BMI Calculator

A simple BMI (Body Mass Index) calculator application built with Spring Boot.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This project is a simple BMI calculator that allows users to calculate their BMI based on their weight and height. It stores the BMI records in a database and provides a RESTful API for interacting with the application.

## Features

- Calculate BMI based on weight and height.
- Validate inputs to ensure weight and height are positive numbers.
- Store BMI records in a database.
- Provide a RESTful API for calculating BMI.

## Prerequisites

- Java 17 or later
- Maven
- MySQL (optional, if you prefer to use MySQL instead of the default H2 database)

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/bmicalculator.git
    cd bmicalculator
    ```

2. Update the application properties:
    If you want to use MySQL, update the `src/main/resources/application.properties` file with your MySQL database credentials:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/bmicalculator
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    ```

## Running the Application

1. Build the project using Maven:
    ```sh
    mvn clean install
    ```

2. Run the application:
    ```sh
    mvn spring-boot:run
    ```

## Testing

1. Run the tests using Maven:
    ```sh
    mvn test
    ```

## Usage

Once the application is running, you can use tools like `curl` or Postman to interact with the API.

## API Endpoints

### Calculate BMI

- **URL:** `/api/bmi/calculate`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "weight": 70,
        "height": 1.75
    }
    ```
- **Response:**
    ```json
    {
        "message": "Your BMI is 22.86"
    }
    ```

## Technologies Used

- Spring Boot
- Spring Data JPA
- H2 Database (default)
- MySQL (optional)
- Maven
- JUnit 5
- Mockito

## Contributing

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
