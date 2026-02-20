# 📚 Student Management System (Spring Boot)

A RESTful backend application built using Spring Boot, JPA, MySQL for managing students with features like CRUD operations, validation, pagination, sorting, and global exception handling.

## 🚀 Features

- Add new students
- Update student name & branch
- Delete students
- View student byId
- Custom Query Methods
   1. Native Query
   2. JPQL
- Pagination & sorting
- Input validation (Name, Email, Age)
- Global exception handling
- DTO + ModelMapper implementation

## 🛠 Tech Stack

- Java
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- REST API
- ModelMapper
- Maven

## Project Structure

com.springboot.student
- ├── controller
- ├── service
- ├── repository
- ├── model
- ├── dto
- ├── exception
- └── config

## 📌 API Endpoints

- POST /api/students/add
- PUT /api/students/update/{id}
- DELETE /api/students/delete/{id}
- GET /api/students/getById/{id}

## Pagination & Sorting

- GET /api/students?page=0&size=5&sortBy=name&direction=asc

## 🗄 Database

- student

## ▶ How to Run

1. Clone the repo  
2. Create database: student_db 
3. Update application.properties  
4. Run the application  


