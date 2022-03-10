# Coding-test

### Prerequisite

This demo project requires:
* JDK 11 or above.
* Maven installation
* Server port 8080 available.

### Steps
1. Create database

    - You need to create database before taking the next steps.

2. Connect to database

    - Open **application.properties** file

    - Configure corresponding database settings

   `spring.datasource.url=${DB_URL}`

   `spring.datasource.username=${DB_USERNAME}`

   `spring.datasource.password=${DB_PASSWORD}`