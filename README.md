# Expense Tracker Application

## Overview
The Expense Tracker Application is a Spring Boot-based web application designed to help users manage their expenses. It allows users to:
- Add new expenses.
- View a list of all expenses.
- Edit existing expenses.
- Delete expenses.

The application uses Thymeleaf for the front end, Spring Data JPA for database interactions, and PostgreSQL as the database.
Application Architecture

## The application follows a typical Spring Boot MVC architecture:

### Controller:
- Handles HTTP requests and responses.

### Service: 
- Contains business logic.

### Repository: 
- Manages database operations.

### Model: 
- Represents the data structure (Expense).

### View:
- Thymeleaf templates for the front end.
  ## Flow of Data
- The user interacts with the Thymeleaf front end.

- The controller receives the request and delegates it to the service layer.

- The service layer processes the request and interacts with the repository.

- The repository performs CRUD operations on the database.

- The response is sent back to the user via the view.
## Testing

The Expense Tracker Application uses a combination of **unit tests** and **integration tests** to ensure the reliability and correctness of the code. Testing is an integral part of the development process, and all tests are automated to provide fast feedback during development and deployment.
