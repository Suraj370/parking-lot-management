# Parking Lot Management System Design Document

## Introduction
The Parking Lot Management System is designed to efficiently manage parking slots, track vehicle entry and exit, and handle payment processing. This document outlines the system's architecture, components, and design considerations.

## System Architecture
The system follows a layered architecture:
- **Controller Layer**: Manages user requests and coordinates responses.
- **Service Layer**: Contains business logic.
- **Data Access Layer**: Interacts with the database to manage data persistence.
- **Model Layer**: Represents the core data structures (e.g., ParkingSlot, ParkingTicket).

## Components
1. **ParkingController**: Handles user requests and responses.
2. **ParkingService**: Contains business logic for parking operations.
3. **ParkingLotDAO**: Data access object for managing parking data.
4. **ParkingSlot**: Represents individual parking slots.
5. **ParkingTicket**: Represents tickets issued for parked vehicles.
6. **Exceptions**: Custom exceptions like `ParkingFullException` and `CarNotFoundException` to handle specific error scenarios.

## Features
- **Vehicle Entry and Exit Tracking**: Records entry and exit times of vehicles.
- **Payment Processing**: Manages payment transactions for parking fees.
- **Availability Tracking**: Monitors the status of parking slots.


## Data Flow
1. **User Interaction**: Users interact with the system through the command line interface.
2. **Request Handling**: Requests are sent to the `ParkingController`.
3. **Business Logic**: The controller delegates tasks to the `ParkingService`.
4. **Data Access**: The service interacts with the `ParkingLotDAO` to fetch or update data.
5. **Response Generation**: Results are sent back to the controller, which responds to the user.

## Technologies Used
- **Java**: Main programming language for the application.
- **Maven**: For project management and dependency handling.

## Installation Instructions
1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn install` to build the project.



## Conclusion
This document outlines the design of the Parking Lot Management System, focusing on its architecture, components, and features. Future improvements will enhance user experience and system functionality.
