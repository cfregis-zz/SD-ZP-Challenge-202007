# SD-ZP-Challenge-202007
A spring boot demo API


This project is an API to register clients. This API use Spring boot, Spring data and H2 in memory database.
The DB schema is been generated automatically by hibenate, and is dropped after the application stop.
The API can be used accessing http://localhost:8080/swagger-ui.html
The challenge_collection file could be imported on postman to use the HTTP methos of this API.
To run this project execute the following commands:

cd clients/
mvn spring-boot:run