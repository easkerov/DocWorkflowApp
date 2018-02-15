Document Workflow Sample App
============================

This is sample Java web application implementing simple document workflow to demo Spring MVC/Hibernate/Spring Security framework features. 

### Frameworks used 
Spring MVC, Spring Security, Hibernate, JUnit, H2 as embedded DB.

### Prerequisites
Minimal:

* JDK 7

Optional:

* Maven 3 if you want to build the project using Maven
* Apache Tomcat 7+ or other servlet containers, if you want to deploy WAR artifact without using embedded container

### How to build and run

1. Clone application sources using `git clone` command 

1. Go to application sources folder and build WAR artifact:

   * You can use Gradle wrapper:

     ```sh
     $ ./gradlew build
     ```

   * Alternatively you can use Maven for artifact building:
    
     ```sh
     $ mvn package
     ```

1. If you want to run application using embedded Tomcat 7 servlet container:

    * Using Maven:

      ```sh
      $ mvn tomcat7:run
      ```

    * Using Gradle wrapper:

      ```sh
      $  ./gradlew appRun
      ```

1.  Open your favourite browser and navigate to http://localhost:9090/

### How to use

By default, there are two embedded users in application:
* `Ivan` (password `Welcome1`)
* `Admin` (password `Welcome1`)

Ivan and Admin can view the list of documents. Ivan can create a new document, but cannot delete documents. Admin can delete the document by number, but cannot create documents.

### Configuration

If you want to change default users, roles and access permissions, then go to `/src/main/java/com/easkerov/docworkflowapp/config/` folder and change defaults in `SecurityConfig.java` class. Embedded H2 DB instance is starting automatically during application start. By default, DB table and data is creating and inserting during application start. If you want to change DB data in Documents table, then go to `/src/main/resources/import.sql` and feel free to edit sql statements there.