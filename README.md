# Product Selection
Server side product selection Rest API

###  Project structure
The project is built using Spring Boot, Spring Rest, Java 8, and Maven.  
The controller's classes are the API end points, and they call the services to get the requested data.  
The products, categories, and locations are stored in a H2 in memory database, managed by JPA repositories.  
There's a boot script that runs automatically on the server's startup, that populates the H2 database.  
All controllers and services have test classes.

### Running the project
Be sure you have installed Java 8, Git, and Maven before run the installation process.  
Since the implementation was built with maven, only execute in the project root folder:

```  
git clone https://github.com/m4rciosouza/sky-server-api  
cd sky-server-api  
mvn package  
java -jar target/sky-server-1.0.0-SNAPSHOT.jar  
```  
  
The Rest API is configured to use the [http://localhost:8080/api/](http://localhost:8080/api) base path.  
For information about the client side, see [https://github.com/m4rciosouza/sky-client-ng2](https://github.com/m4rciosouza/sky-client-ng2)  