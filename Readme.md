# Vet Clinic Management System

## Introduction
This project is a CRUD Java Spring Boot application for a vet clinic that stores the information of pets, owners, and appointments in an SQL Server database. The application also has a Kafka pipeline integrated to send confirmation emails to the pet owners when an appointment is made.

## Technologies Used
- Java 11
- Spring Boot 2.5.1
- JPA
- SQL Server
- Kafka

## Features
- Create, read, update, and delete pet information
- Create, read, update, and delete owner information
- Create, read, update, and delete appointment information
- Integration with Kafka to send confirmation emails to owners when an appointment is made

## Installation

Clone the repo and then do the following:

You need to create and populate the entire application.properties file that is located in src/main/resources with the following template
```json
server.address=127.0.0.1
server.port=4000

spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=AnubisDB;Trusted_Connection=True;
spring.jpa.properties.hibernate.format_sql=true
spring.datasource.username=
spring.datasource.password=
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create-drop

spring.kafka.bootstrap-servers=localhost:9092

spring.mail.host=your.smtp.host
spring.mail.port=your.smtp.port
spring.mail.username=your.email.username
spring.mail.password=your.email.password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

1. Got to the [Apache Quickstart](https://kafka.apache.org/quickstart) and follow the instructions. By default it should start in 9092
2. Create the database using your favorite SQL Server Management Service. Then change the name in the spring.datasource.url field
3. Populate your username and password to access the DB
4. Change the properties for your email sending configuration
5. After that you should be ready to run the app using Maven 