# Architecture Decisions
`This file is about the decisions I had made for this project`

## Why chosen Long instead UUID for userId and paymentId?
    - For a small project we have smaller index size
    - It has better DB performance
    - Faster joins

## Why chosen constructor injection (final) instead of field injection (@Autowired) when doing dependency?
    - Easier to Unit Test
    - Constructor injection exposes over-coupling immediately
    - Fit SOLID principles
