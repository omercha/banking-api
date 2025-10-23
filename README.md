# Banking API

A simple Spring Boot project built to learn the framework by modelling core banking services as RESTful APIs.

## Tech Stack

* Java (Spring Boot)
* PostgreSQL
* Postman
* Docker

## Current API Endpoints

* `POST /api/accounts`: Create a new bank account.
* `GET /api/accounts/{id}`: Get details for a specific account.
* `GET /api/accounts`: Get details of all accounts.
* `PUT /api/accounts/{id}/deposit`: Deposit funds into an account.
* `PUT /api/accounts/{id}/withdraw`: Withdraw funds from an account.
* `DELETE /api/accounts/{id}`: Delete an account.

## Stretch Goals (to-do)

* Add API endpoint to transfer money between two accounts.
* Use Spring Security to secure endpoints (user authentication with JWT).
* Improve exception handling (e.g., `AccountNotFoundException`, `InsufficientFundsException`).
* Write tests for the service layer and controller endpoints with JUnit.
* Design a basic UI with React and connect it to the backend.
* Refactor the project into a microservices-based application.
