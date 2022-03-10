# Coding-test

### Prerequisite

This demo project requires:
* JDK 11 or above.
* Maven installation
* Server port 8080 available.

### Steps
1. Create database

    - You need to create database before taking the next steps.

| Field       | Type         | Null | Key | Extra          |
|-------------|--------------|------|-----|----------------|
| id          | bigint(20)   | NO   | PRI | auto_increment |
| suburb_name | varchar(255) | YES  |     |                |
| postcode    | bigint(20)   | YES  |     |                |

2. Connect to database

    - Open **application.properties** file

    - Configure corresponding database settings

       `spring.datasource.url=${DB_URL}`
        `spring.datasource.username=${DB_USERNAME}`
        `spring.datasource.password=${DB_PASSWORD}`

### Controller
* API add new post: 
   - URL: `api/v1/post`
   - Method: POST
   - Body:
     ```
     {
         "suburb_name": "Hanoi", // Suburb name
         "postcode": 100000 // Suburb's postal code
      }
     ```

* API get all post:
  * URL: `api/v1/post`
  * Method: GET
  * Body: none // No request body.

* API get specific posts with postcodes:
  - URL: `api/v1/post`
  - Method: GET
  - Body:
    ```
        100000, 18190, ... // An array of postcode number
    ```