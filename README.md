# 🚆 Online Reservation System

A desktop-based **Online Reservation System** developed using **Java Swing, JDBC, and SQLite**. The application enables users to manage railway reservations efficiently through an intuitive graphical interface, including ticket booking, searching, updating, cancellation, and reservation history management.

---

## 📌 Features

- 🔐 Admin Login Authentication
- 🎫 Book New Reservation
- 🔍 Search Reservation
- ✏️ Update Reservation Details
- ❌ Cancel Reservation
- 📋 View All Reservations
- 🆔 Auto-Generated PNR Number
- ✔️ Input Validation
- 💾 SQLite Database Integration
- 🖥️ Java Swing GUI
- 🏗️ MVC Architecture

---

## 🛠️ Technologies Used

- Java
- Java Swing
- JDBC
- SQLite
- Eclipse IDE
- Git & GitHub

---

## 📂 Project Structure

```
OnlineReservationSystem
│
├── src
│   ├── database
│   ├── gui
│   ├── model
│   ├── service
│
├── database
│
├── docs
│
├── screenshots
│
├── lib
│
└── README.md
```

---

## 🗄️ Database

### users

| Column | Type |
|---------|------|
| id | INTEGER |
| username | TEXT |
| password | TEXT |

---

### reservations

| Column | Type |
|---------|------|
| reservation_id | INTEGER |
| pnr_number | TEXT |
| passenger_name | TEXT |
| train_number | TEXT |
| train_name | TEXT |
| class_type | TEXT |
| journey_date | TEXT |
| from_station | TEXT |
| to_station | TEXT |

---

## 🚀 How to Run

### 1. Clone Repository

```bash
git clone https://github.com/hrishikeshpatole14/OnlineReservationSystem.git
```

---

### 2. Open in Eclipse

Import the project into Eclipse IDE.

---

### 3. Add SQLite JDBC Driver

Add

```
sqlite-jdbc-3.53.2.0.jar
```

to the project's Build Path.

---

### 4. Initialize Database

Run

```
DatabaseInitializer.java
```

Then run

```
InsertDefaultUser.java
```

---

### 5. Start Application

Run

```
LoginFrame.java
```

---

## 🔑 Default Login

Username

```
admin
```

Password

```
admin123
```

---

## 📸 Screenshots

Add screenshots inside the **screenshots** folder.

Example:

```
screenshots/

login.png

dashboard.png

reservation.png

search_reservation.png

update_reservation.png

view_reservations.png

cancel_reservation.png
```

---

## 📚 Learning Outcomes

This project helped in understanding:

- Java Swing GUI Development
- JDBC Connectivity
- SQLite Database Integration
- CRUD Operations
- MVC Architecture
- Event Handling
- Input Validation
- Exception Handling
- PNR Generation Logic
- Git & GitHub Version Control

---

## 🔮 Future Enhancements

- Customer Login System
- Online Payment Integration
- Seat Availability Checking
- Train Schedule Management
- Email/SMS Ticket Confirmation
- PDF Ticket Generation
- Admin Dashboard with Analytics

---

## 👨‍💻 Developed By

**Hrishikesh Patole**

B.E. Computer Engineering

Java Full Stack Developer

**GitHub:**
https://github.com/hrishikeshpatole14

**LinkedIn:**
https://www.linkedin.com/in/hrishikesh-patole

---

⭐ If you found this project useful, don't forget to Star the repository.
