# 📒 Contact Manager App

A Java-based desktop application for managing contacts with a user-friendly GUI. Built using Swing for the interface and JDBC for seamless MySQL database integration.

![App Screenshot](https://raw.githubusercontent.com/aliabdelmoaty/contact-manager-app/main/src/main/resources/icons/project.png)
---
## 🚀 Features

- **Full CRUD Operations**
  - Create new contacts with validation
  - Read and display all contacts in a sortable table
  - Update existing contact information
  - Delete contacts with confirmation
- 🔍 Advanced Search
  - Search by ID, name, or email
  - Real-time search results
- 🎨 Custom UI Components
  - Rounded text fields with input hints
  - Animated buttons with hover effects
  - Responsive table with column sorting
- 🔒 Input Validation
  - Email format verification
  - Phone number validation (Egyptian format)
  - Address/Name format checks
---

## 🖥 Usage Guide

1. **Add New Contact**
   - Fill all fields with valid data
   - Click "Add" button
   - Automatic validation ensures proper formatting

2. **Search Contacts**
   - Type in search field (supports partial matches)
   - Results update in real-time

3. **Edit/Delete**
   - Select a row in the table
   - Click "Edit" or "Delete" buttons
   - Confirm changes in dialog

4. **Sorting**
   - Use dropdown to select A-Z/Z-A sorting
   - Click column headers for secondary sorting
  ---
## 🛠 Technologies Used

- **Core**: Java 17
- **GUI**: Java Swing
- **Database**: MySQL
- **ORM**: JDBC
- **Tools**: XAMPP, Maven

## ⚙️ Setup Instructions

### Prerequisites
- Java JDK 17+
- XAMPP (for MySQL)
- Maven

### Installation
1. **Database Setup**
```bash
# Start XAMPP services
# launch XAMPP Control Panel on Windows

# Create database (via phpMyAdmin or MySQL CLI)
CREATE DATABASE contacts;
USE contacts;

CREATE TABLE contacts (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  address VARCHAR(255) NOT NULL,
  time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

2. **Configure Database Connection**  
Update credentials in `SQLServer.java`:
```java
private static final String JDBC_URL = "jdbc:mysql://localhost/contacts";
private static final String userName = "root";
private static final String password = "";
```
3. download https://www.apachefriends.org/
4. open the first two modules.
  ![XAMPP Logo](https://github.com/aliabdelmoaty/contact-manager-app/raw/main/src/main/resources/icons/XAMPP.png)


5. create database in http://127.1.1.0/phpmyadmin/index.php?route=/server/databases name data is 'contacts' and type is 'Collation'


6. Update the `JDBC_URL`, `userName`, and `password` in [`SQLServer.java`](src/main/java/logic/SQLServer.java) to match your MySQL server details "If you haven't done the previous step, which is step 5, take this step."
---

## 🐛 Troubleshooting

| Issue | Solution |
|-------|----------|
| Connection Failed | Ensure MySQL is running in XAMPP |
| Validation Errors | Check input formats (tooltips show requirements) |
| Empty Table | Verify database contains 'contacts' table |
| UI Glitches | Update Java to latest version |


**Code Standards**
- Follow Java naming conventions
- Include Javadoc comments for new methods
- Maintain 4-space indentation
- Write unit tests for new features

---

**Made with ❤️ by [Ali Mohamed]**  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue)](https://linkedin.com/in/ali-abdelmoaty10) 
```
