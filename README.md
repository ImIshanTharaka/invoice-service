# invoice-service
An application for retrieving data from an excel file, save them in a database and generating a pdf invoice from that data and then send it to the relevant customer.

## Specifications
This application consists of 3 microservices.
1. excel-to-database - retrieving data from a excel file, save them in a MySQL database
2. pdf-creation - getting data from the MySQL databse and generating a pdf invoice from that data according to a given template, then saving the generated invoice in the database
3. email-service - getting the customer email address, and the invoice by calling the database and then sending an email to the customer attaching the invoice

## What I have learned
* Extracting data from a excel file and save them in a MySQL database
* Use thymeleaf and html2pdf dependencies to create the html file and convert the html to pdf
* Use Gmail SMTP server to send emails through a Gmail account
* Setup communication between multiple microservices

## Used technologies
* Java
* Springboot
* MySQL

## How to run the application
* Enable SMTP in Gmail settings for the email
* Update the Mysql database url, username, password and gmail smtp username, password in the application properties files
* Run the 3 microservices parallelly and hit a request with the excel file to the excel-to-databse microservice 

