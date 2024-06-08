# Spring Microservices Learning Project

Welcome to the Spring Microservices Learning Project! This repository is dedicated to learning and implementing various
concepts and technologies related to microservices using Spring Boot and Spring Cloud.

## Table of Contents

- [Introduction](#introduction)
- [Technologies and Concepts](#technologies-and-concepts)
- [Project Setup](#project-setup)
- [Modules](#modules)
    - [REST API and REST Web Services](#rest-api-and-rest-web-services)
    - [Microservices with Spring Boot and Spring Cloud](#microservices-with-spring-boot-and-spring-cloud)
    - [Orchestration with Kubernetes](#orchestration-with-kubernetes)
    - [Containerization with Docker](#containerization-with-docker)
    - [Exception Handling, Validation, HATEOAS, and Filtering](#exception-handling-validation-hateoas-and-filtering)
    - [Client-side Load Balancing, Dynamic Scaling, and API Gateway](#client-side-load-balancing-dynamic-scaling-and-api-gateway)
    - [Centralized Configuration with Spring Cloud Config Server](#centralized-configuration-with-spring-cloud-config-server)
    - [Distributed Tracing with Spring Cloud Sleuth and Zipkin](#distributed-tracing-with-spring-cloud-sleuth-and-zipkin)
    - [Fault Tolerance with Hystrix](#fault-tolerance-with-hystrix)
    - [Versioning RESTful Web Services](#versioning-restful-web-services)
    - [Monitoring with Spring Boot Actuator](#monitoring-with-spring-boot-actuator)
    - [Documentation with Swagger](#documentation-with-swagger)
    - [Best Practices in Designing RESTful Web Services](#best-practices-in-designing-restful-web-services)
    - [Spring Cloud Bus](#spring-cloud-bus)
    - [Feign REST Client](#feign-rest-client)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This project aims to provide a comprehensive learning experience in developing and managing microservices using Spring
Boot and Spring Cloud. Each module is designed to cover specific aspects of microservices, from basic REST API
development to advanced topics like distributed tracing and fault tolerance.

## Technologies and Concepts

- **Spring Boot**
- **Spring Cloud**
- **Kubernetes**
- **Docker**
- **Spring Cloud Config Server**
- **Spring Cloud Sleuth**
- **Zipkin**
- **Hystrix**
- **Eureka Naming Server**
- **Ribbon**
- **Zuul**
- **Spring Boot Actuator**
- **Swagger**
- **Spring Cloud Bus**
- **Feign REST Client**

## Project Setup

To set up the project locally, follow these steps:

1. Clone the repository:
    ```bash
    git clone https://github.com/niruparekh09/Spring-Microservices.git
    ```
2. Navigate to the project list:
    ```bash
    cd Spring-Microservices
    ```
3. Navigate to the project directory:
    ```bash
    cd Spring-Project-Name
    ```
4. Build the project using Maven:
    ```bash
    mvn clean install
    ```
5. Run the project:
    ```bash
    mvn spring-boot:run
    ```

## Modules

### REST API and REST Web Services

Learn to develop and design RESTful web services using Spring Boot, including exception handling, validation, HATEOAS,
and filtering.

### Microservices with Spring Boot and Spring Cloud

Explore how to build microservices architecture using Spring Boot and Spring Cloud, focusing on scalability, resilience,
and fault tolerance.

### Orchestration with Kubernetes

Understand how to deploy and manage microservices using Kubernetes for orchestration, ensuring high availability and
scalability.

### Containerization with Docker

Create Docker containers for your microservices to ensure consistency across different environments and ease of
deployment.

### Exception Handling, Validation, HATEOAS, and Filtering

Implement robust exception handling, input validation, HATEOAS for hypermedia-driven APIs, and data filtering techniques
in your RESTful services.

### Client-side Load Balancing, Dynamic Scaling, and API Gateway

- **Ribbon:** Implement client-side load balancing.
- **Eureka Naming Server:** Enable dynamic scaling and service discovery.
- **Zuul:** Set up an API Gateway for routing and filtering requests.

### Centralized Configuration with Spring Cloud Config Server

Set up a centralized configuration server to manage configuration across all your microservices.

### Distributed Tracing with Spring Cloud Sleuth and Zipkin

Implement distributed tracing to monitor and troubleshoot requests as they flow through multiple microservices.

### Fault Tolerance with Hystrix

Use Hystrix to implement fault tolerance and resilience in your microservices, handling failures gracefully.

### Versioning RESTful Web Services

Learn best practices for versioning your RESTful web services to ensure backward compatibility.

### Monitoring with Spring Boot Actuator

Utilize Spring Boot Actuator to monitor and manage your microservices, gaining insights into their health and
performance.

### Documentation with Swagger

Document your RESTful APIs using Swagger for easy testing and client generation.

### Best Practices in Designing RESTful Web Services

Understand and implement best practices for designing robust, scalable, and maintainable RESTful web services.

### Spring Cloud Bus

Use Spring Cloud Bus to exchange messages about configuration updates and synchronize configuration changes across
microservices.

### Feign REST Client

Simplify communication between microservices using the Feign REST Client, enabling easy and declarative HTTP client
creation.
