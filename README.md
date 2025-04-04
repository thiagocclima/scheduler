# Bank Transactions Scheduler

This project was made as part of technichal test for Natixis.

## Running
To run the project you'll need JDK 17 and Maven. The project is a Spring Boot application and uses an H2 database, so you don't to install any other tool.

For the first run Maven will need to download dependencies. To do this, run the below command
> mvn install

To run the project go to the root folder of the project and run
> mvn spring-boot:run

If you need to run the tests
> mvn test

## Database
To see the database console start the application, open your browser and go to 
> http://localhost:8080/h2-console

You may need to set the correct JDBC URL to
> jdbc:h2:mem:bank

## API
There is also a Postman collection into the root directory to play with the running app.
