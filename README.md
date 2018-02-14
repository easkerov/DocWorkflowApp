# Document Workflow Sample App

This is sample Java Web application implementing simple document workflow to demo Spring MVC/Hibernate/Spring Security framework features. 

### Frameworks used: 
Spring MVC, Spring Security, Hibernate, H2 as embedded DB.

### Prerequisites
Minimal:
* JDK 7 and higher
* Maven 3 and higher

Optional:

* Apache Tomcat 7 and higher servlet container if you want to deploy WAR artifact without using embedded container

### How to build and run

Clone application sources using `git clone` command and run Maven to build and package application WAR artifact:

```sh
$ mvn package
```
If you want to run application using embedded Tomcat servlet container then run:
```sh
$ mvn tomcat7:run
```
Open browser and navigate to http://localhost:9090/

### How to use

By default, there are 2 users in app:
* Ivan (password Welcome1)
* Admin (password Welcome1)

Ivan and Admin can view the list of documents. Ivan can create a new document, but cannot delete documents. Admin can delete the document by number, but cannot create documents.

### Configuration

If you want to change default users, roles and access permissions, then go to `/src/main/java/com/easkerov/docworkflowapp/config/` folder and change defaults in `SecurityConfig.java` class. Embedded H2 DB instance is starting automatically during application start. By default, DB table and data is creating and inserting during application start. If you want to change DB data in Documents table, then go to `/src/main/resources/import.sql` and feel free to edit sql statements there.