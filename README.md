# Spring Blog

- JPA: Java Persistence API
    - just an interface!
    - Hibernate is one of the most common implementations
- Spring Data: integrates JPA w/ Spring
    - under the hood, uses hibernate, but we won't interact w/ it directly
    - `starter` dependency in the `pom.xml`

[More details on JPA vs Spring Data vs Hibernate][1]

[1]: https://coderanch.com/t/685335/certification/JPA-Spring-JPA-Spring-Data

## Relationship Types

One-To-One

- user -> user_profile
    In the database:
    - separate user and user_profile tables
    - user table has a profile_id column that's a foreign key to user profiles
    - user_profiles table has a user_id column that's a foreign key to users
    In Java
    - User class
        - property UserProfile profile;
    - UserProfile class
        - property User user;

One-To-Many

- students <-> quizzes
- driver <-> car
- car_manufacturer <-> car_model
- ship <-> sailor
- salesperson <-> customer
- authors <-> books
    Relational
    - authors table
    - books table have author_id column foreign key to authors
    Java
    - Author class
        - String name
        - int age
        - List<Book> books
    - Book class
        - String title
        - String isbnNo
        - Author author

Many-To-One

- Teachers <-> Class
- Employees <-> Department
- Classes <-> Interface
- Developers <-> Application
    Relational
    - developers table has a application_id column, foreign key to applications
    - applications table
    Java
    - Developer
        - String name
        - String favoriteLanguage
        - String cofeePreference
        - int frustrationLevel
        - Application assignedApplication
    - Application
        - String title
        - String versionNo
        - long numberOfBugs
        - List<Developer> developers

Many-To-Many

- dogs <-> breeds
- parents <-> offspring
- kids <-> shoes
- employees <-> departments
- managers <-> departments
- recipes <-> ingredients
- categories <-> ads
    Relational Model
    - categories table
    - ads table
    - ad_category table (link table, join table, composite table) has ad_id and category_id columns that are both foreign keys
    OOP Model
    - Category class
        - String name
        - List<Ad> ads
    - Ad class
        - String title
        - String description
        - List<Category> categories


