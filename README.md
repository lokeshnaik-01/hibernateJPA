# hibernateJPA

# Command Line Runner
  - Command-line runners are a useful functionality to execute the various types of code that only have to be run once, right after application startup.

# Hibernate
- A framework persisting/saving Java objects in DB
- it handles all the low-level SQL code
- Minimizes amount of JDBC code you have to develop
- Hibernate provided ORM(Object to Relational Mapping)
## ORM
- developer define mapping between java class and database table
- JavaClass <-------> Hibernate <---------> Database Table

# JPA (Jakarta Persistence API)
- Standard API for OPM
- Only a specification
    - Defines a set of interfaces
    - Requires an implementation to be usable
- Hibernate is the most popular implementation of JPA
## Benefits of JPA
- By having standard API you are not locked to vendor's implementation
- Maintain portable, flexible code by coding to JPA spec(interfaces)
- Can switch between two vendor implementations

## DB Calls
- `entityManager` is a special JPA object or JPA helper object
- used to store the data into database
- `persist` is used to insert
- `find` to retrieve data based on a key
- Hibernate JPA uses JDBC for DB communications

# DB Connection
- `spring.datasource.url` specify the host
- `spring.datasource.username` specify the username
- `spring.datasource.password` specify the password
- spring will automatically connect to jdbc if specified in url

# Entity Class
- Java class that is mapped to database table
- Entity class should be annotated with `@Entity`
- Must have public or protected no-argument constructor
  - Class can have other constructor