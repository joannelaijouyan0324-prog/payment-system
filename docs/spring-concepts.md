# Spring Concepts – Spring Boot Payment System

## What @RestController Really Does
    It tells spring: 
        - This class handles HTTP requests 
        - The return value of its methods should be written directly to the response body (usually JSON)

## What @GetMapping("/health") Really Does
    - It registers this method into Spring’s routing system.
    - HTTP GET route registration.