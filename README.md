# Spring Boot Users REST API (DAO Layer)

A beginner-friendly Spring Boot project that creates `GET /api/users` and returns all users from the DAO layer as JSON.

## Task requirements covered

1. Define `UserController` with `@RestController`.
2. Inject `UserDAO` using `@Autowired` constructor injection.
3. Add a `@GetMapping` method that returns `List<User>` from the DAO.
4. Handle SQL/database exceptions using `@ExceptionHandler`.
5. Test the endpoint with Postman and verify the JSON response.

## Technologies

- Java 17
- Spring Boot 3.4.5
- Spring Web
- Spring JDBC (`JdbcTemplate`)
- H2 in-memory database
- Maven
- Postman

## Project structure

```text
users-dao-api/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/com/example/usersapi/
    │   │   ├── UsersApiApplication.java
    │   │   ├── controller/UserController.java
    │   │   ├── dao/UserDAO.java
    │   │   ├── dao/UserDAOImpl.java
    │   │   └── model/User.java
    │   └── resources/
    │       ├── application.properties
    │       ├── schema.sql
    │       └── data.sql
    └── test/java/com/example/usersapi/
        └── UsersApiApplicationTests.java
```

## Requirements

Install:
- JDK 17 or later
- Apache Maven 3.8+
- IntelliJ IDEA, Eclipse, or VS Code
- Postman (for API testing)

Check Java and Maven:

```bash
java -version
mvn -version
```

## Run the project

1. Extract the ZIP file.
2. Open the `springboot-users-dao-task` folder in IntelliJ IDEA or VS Code.
3. Wait for Maven to download dependencies.
4. Open a terminal in the folder containing `pom.xml`.
5. Run:

```bash
mvn clean spring-boot:run
```

The application starts at `http://localhost:8080`.

Alternatively, run `UsersApiApplication.java` from the IDE.

## Test with Postman

- Method: `GET`
- URL: `http://localhost:8080/api/users`
- Body: None
- Click **Send**.

Expected status: `200 OK`

Expected JSON:

```json
[
  {
    "id": 1,
    "name": "Aarav Sharma",
    "email": "aarav@example.com"
  },
  {
    "id": 2,
    "name": "Priya Patil",
    "email": "priya@example.com"
  },
  {
    "id": 3,
    "name": "Rahul Verma",
    "email": "rahul@example.com"
  }
]
```

The sample records are inserted automatically from `data.sql` whenever the application starts.

## How it works

1. Postman sends a GET request to `/api/users`.
2. `UserController` receives the request.
3. The controller calls `UserDAO.findAllUsers()`.
4. `UserDAOImpl` runs a SELECT query using `JdbcTemplate`.
5. The DAO returns a `List<User>`.
6. Spring converts the list into JSON and sends it as the response.
7. If a database exception occurs, the controller's `@ExceptionHandler` returns an HTTP 500 error response.

## Optional: View the H2 database

While the application is running, open:

`http://localhost:8080/h2-console`

Use:
- JDBC URL: `jdbc:h2:mem:usersdb`
- User Name: `sa`
- Password: leave blank

Click **Connect** and run:

```sql
SELECT * FROM users;
```

## Run tests

```bash
mvn test
```

## Important notes

- This project uses an H2 in-memory database, so it does not require MySQL or XAMPP.
- Data is recreated from `schema.sql` and `data.sql` when the application starts.
- `JdbcTemplate` converts many JDBC SQL exceptions into Spring's `DataAccessException`; the handler covers both `SQLException` and `DataAccessException`.
- This is a simple learning task and does not include authentication or write/update/delete endpoints.
