# Architecture Decisions
`This file is about the decisions I had made for this project`

## Layered Architecture Overview
Client → Controller → Service → Repository → Database

### Controller Layer
#### Responsibility: Handle HTTP communication
- Accepts JSON request
- Maps JSON → DTO
- Calls service layer 
- Maps entity → response DTO
- Returns HTTP response

- Example: 
```
@PostMapping
public UserResponse createUser(@RequestBody CreateUserRequest request)
```

### Service Layer
#### Responsibility: Contain business logic and system rules
- Create new User entity
- Set system-managed fields (status, timestamps)
- Apply business logic (future: validation, hashing)
- Call repository to persist

### Repository Layer
#### Responsibility: Data access abstraction
- Extends JpaRepository
- Provides CRUD operations automatically
- No business logic inside repository

Repository is responsible only for database communication.
Spring Data JPA automatically generates implementation at runtime.

## Data Flow (POST/users)
1. Client sends JSON request
2. Controller converts JSON → DTO
3. Controller calls service
4. Service creates entity and sets rules
5. Service calls repository.save()
6. Repository persists entity to database
7. Saved entity returned to controller
8. Controller maps entity → response DTO
9. JSON response returned to client

### Why this architecture?
To prevents tight coupling between HTTP layer and database layer

### Why chosen Long instead UUID for userId and paymentId?
- For a small project we have smaller index size
- It has better DB performance
- Faster joins

### Why chosen constructor injection (final) instead of field injection (@Autowired) when doing dependency?
- Easier to Unit Test
- Constructor injection exposes over-coupling immediately
- Fit SOLID principles

This architecture design follows common backend best practices used in production-grade Spring Boot 
applications.