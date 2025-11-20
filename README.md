# GitHubAsk

A backend microservice built with Java 17 and Spring Boot that integrates with the GitHub REST API to serve repository, branch and commit information.

## Features
- Access GitHub public API to fetch repositories, branches and commits for a given user  
- Layered architecture: Controller → Service → Client → DTO → Response  
- Full error handling including GitHub API rate-limit responses  
- Docker Compose setup for local deployment of service + dependencies  
- Ready for extension into microservices / cloud deployment

## Tech Stack
- Java 17  
- Spring Boot (Spring Web, Spring Data / Client)  
- GitHub REST API  
- Maven build system  
- Docker & Docker Compose  
- Git / GitHub  

## How to run locally
1. Clone the repository  
2. Execute `docker-compose up` (starts the application)  
3. Open `http://localhost:8080` (or configured port)  
4. Try endpoint e.g. `/api/repos/{username}`, `/api/repos/{username}/{repo}/commits`  

## What I learned
- How to consume a third-party REST API and map responses into internal DTOs  
- How to design and implement a clean backend service with layered architecture  
- How to handle external API failure modes (rate limiting, timeouts)  
- How to set up local development environment using Docker Compose  

## Future improvements
- Add unit & integration tests (JUnit, Mockito)  
- Add caching (Redis) for external API calls to optimise performance  
- Containerise and deploy to Kubernetes / Cloud (GCP/AWS)  
- Provide full API documentation (Swagger / OpenAPI)  
