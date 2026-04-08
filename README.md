# Rewards API

## Overview
Spring Boot API to calculate customer reward points based on transactions.

## Features
- Monthly reward calculation
- Total reward calculation
- Dynamic month handling
- Unit & integration tests
- Exception handling

## API
GET /api/rewards

## Sample Output
[
  {
    "customerId": 1,
    "monthlyPoints": {
      "Jan": 90,
      "Feb": 25
    },
    "totalPoints": 115
  }
]

## Run
mvn spring-boot:run