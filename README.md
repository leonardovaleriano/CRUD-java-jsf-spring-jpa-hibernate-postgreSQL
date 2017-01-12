# A Java Web Application for a simple CRUD

This is a web application for a CRUD of Articles (title and text) in a java. The application uses the spring framework integrated with JSF, JPA, and Hibernate. The PostgreSQL is used as the database system.

Before use this project, set the username and password of the database in the __applicationContext.xml__ file. The file is in src/main/webapp/WEB-INF/ folder.

This project uses Maven to manage the dependencies, build the source code and package the application. For all that, open a terminal in the project folder and execute the following command:

```shell
mvn clean package
```

The tomcat is used as the application server. To run the server, open a terminal in the project folder and execute: 

sh target/bin/webapp

Thanks!
