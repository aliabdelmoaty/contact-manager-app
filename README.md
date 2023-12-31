# Contact Manager App


## Description
This is a Java project that uses JDBC to connect to a MySQL database. It provides a GUI for managing contacts, with features to create, read, update, and delete (CRUD) contact records. It also includes animations for better user experience.

## Features
- Connect to a MySQL database
- Create a new contact with name, email, phone, and address
- Read all contacts from the database
- Update a contact's details
- Delete a contact by ID
- search a contact by id name email
- change a shape button and textField

## Setup
1. Clone the repository
2. Ensure you have Java and Maven installed on your machine
3. download https://www.apachefriends.org/
4. open the first two modules.
  ![XAMPP Logo](https://github.com/aliabdelmoaty/contact-manager-app/raw/main/src/main/resources/icons/XAMPP.png)


5. create database in http://127.1.1.0/phpmyadmin/index.php?route=/server/databases name data is 'contacts' and type is 'Collation'


6. Update the `JDBC_URL`, `userName`, and `password` in [`SQLServer.java`](src/main/java/logic/SQLServer.java) to match your MySQL server details "If you haven't done the previous step, which is step 5, take this step."
7. Run the project using your preferred IDE or from the command line with `mvn exec:java`


## Design 
this design application 
![App Design](https://github.com/aliabdelmoaty/contact-manager-app/raw/main/src/main/resources/icons/project.png)

## Usage
Run the `main` method in [`Project.java`](src/main/java/main/java/Project.java). This will launch a GUI where you can manage your contacts.


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

