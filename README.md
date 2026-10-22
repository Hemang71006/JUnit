# User Registration System with JUnit 5

## Overview

The User Registration System is a Java-based application that validates user
registration details before accepting user entry.

The application uses Regular Expressions (Regex) to validate first name, last
name, email address, mobile number, and password requirements. JUnit 5 is used
to verify that valid entries are accepted and invalid entries are rejected.

The project covers the 11 use cases specified in the Bridgelabz User
Registration Problem assignment.

## Objectives

- Implement the required user registration validations using Java.
- Use Regex to check registration fields against their specified rules.
- Write JUnit 5 tests for valid and invalid inputs.
- Use parameterized tests to validate multiple email samples.
- Follow the required Git branching and merging strategy.
- Test each use case before integrating it into the `develop` branch.

## Technologies Used

- Java
- Maven
- JUnit 5
- Regular Expressions (Regex)
- Git and GitHub
- IntelliJ IDEA

## Use Cases Covered

| Use Case | Description | Requirement |
|---|---|---|
| UC 1 | First Name Validation | First name must start with a capital letter and contain at least 3 characters. |
| UC 2 | Last Name Validation | Last name must start with a capital letter and contain at least 3 characters. |
| UC 3 | Email Validation | Email must contain the 3 mandatory parts (`abc`, `bl`, `co`) and may contain the 2 optional parts (`xyz`, `in`), with the required `@` and `.` positions. Example: `abc.xyz@bl.co.in`. |
| UC 4 | Mobile Format Validation | Mobile number must contain a country code, followed by a space and a 10-digit number. Example: `91 9919819801`. |
| UC 5 | Password Rule 1 | Password must contain a minimum of 8 characters. |
| UC 6 | Password Rule 2 | Password must contain at least 1 uppercase character. |
| UC 7 | Password Rule 3 | Password must contain at least 1 numeric digit. |
| UC 8 | Password Rule 4 | Password must contain exactly 1 special character. All password rules must be satisfied. |
| UC 9 | Email Sample Validation | Email validation should pass all email samples supplied separately with the assignment. |
| UC 10 | JUnit Validation Tests | Write happy-path and sad-path JUnit tests for first name, last name, email, mobile number, and password. |
| UC 11 | Parameterized Email Tests | Write a JUnit parameterized test to validate multiple email-address inputs. |

## Testing Approach

JUnit 5 will be used to test each validation method.

### Happy-Path Tests
Check that valid input satisfies the required validation rules.

### Sad-Path Tests
Check that invalid input is rejected, such as:
- Names that do not start with a capital letter.
- Names shorter than the required length.
- Incorrect email formats.
- Mobile numbers that do not follow the specified format.
- Passwords that fail one or more required rules.

### Parameterized Tests
Use JUnit parameterized tests to run email validation against multiple inputs,
including the email samples supplied separately with the assignment.

## Project Structure

The project follows a Maven directory structure:

```text
JUnit/
├── README.md
├── pom.xml
└── src/
    ├── main/
    │   └── java/
    │       └── registration/
    │           └── UserRegistration.java
    └── test/
        └── java/
            └── registration/
                ├── UserRegistrationTest.java
                └── EmailValidationParameterizedTest.java
