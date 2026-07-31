# 🦷 Dentist Office Management System

A Java web application developed as an academic project to manage patients, dentists, and appointments in a dental office.

## Overview

The Dentist Office Management System provides separate experiences for patients and dentists through role-based authentication.

The application allows users to manage patient records, dentist information, and appointments while enforcing business rules to prevent scheduling conflicts.

This project was developed to practice Java web development using JSP, Servlets, JDBC, and the MVC architecture.

---

## Features

### Authentication

- Patient login
- Dentist login
- Session-based authentication
- Role-based access

### Patient Features

- View personal information
- Update profile information
- View appointments
- Schedule new appointments
- Update appointments
- Cancel appointments

### Dentist Features

- View dentist information
- Update dentist information
- View scheduled appointments
- Access patient appointment information

### Appointment Management

- Create appointments
- Search appointments
- Update appointments
- Delete appointments
- Prevent duplicate appointments for patients
- Prevent scheduling conflicts for dentists

---

## Technologies

- Java
- Jakarta Servlets
- JSP
- JDBC
- Microsoft Access
- UCanAccess
- Maven
- Apache Tomcat
- HTML
- CSS

---

## Project Structure

```text
src/
└── main/
    ├── java/
    │   └── com/example/dentistoffice/
    │       ├── Appointment.java
    │       ├── AppointmentAddServlet.java
    │       ├── AppointmentDeleteServlet.java
    │       ├── AppointmentList.java
    │       ├── AppointmentLookupServlet.java
    │       ├── AppointmentUpdateServlet.java
    │       ├── Dentist.java
    │       ├── DentistAppointmentServlet.java
    │       ├── DentistUpdateServlet.java
    │       ├── LoginServlet.java
    │       ├── Patient.java
    │       ├── PatientUpdateServlet.java
    │       └── Procedure.java
    │
    └── webapp/
        ├── images/
        ├── WEB-INF/
        │   ├── db/
        │   └── web.xml
        └── JSP pages
```

---

## Database

The application uses a **Microsoft Access** database located in:

```text
src/main/webapp/WEB-INF/db/
```

Database communication is implemented through **JDBC** using the **UCanAccess** driver.

---

## Getting Started

### Requirements

- Java JDK
- Apache Tomcat
- Maven
- IntelliJ IDEA (or another Java IDE)

### Running the Project

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Allow Maven to download all dependencies.
4. Configure an Apache Tomcat server.
5. Deploy the application.
6. Run Tomcat and open the application in your browser.

> Depending on your local environment, the Microsoft Access database path may need to be adjusted.

---

## Concepts Demonstrated

- Object-Oriented Programming (OOP)
- MVC Architecture
- JSP & Servlets
- Session Management
- CRUD Operations
- JDBC Database Connectivity
- Form Processing
- Business Rule Validation
- Maven Project Structure

---

## Future Improvements

- Migrate the database to MySQL or PostgreSQL
- Encrypt user passwords
- Improve authentication and authorization
- Enhance the user interface
- Add automated tests
- Deploy the application to a cloud platform

---

## Author

**Ingrid Pimentel**

Computer Programming Graduate  
Atlanta, Georgia

GitHub: https://github.com/ingridsoaresp
