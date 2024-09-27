### Introduction to Eureka Naming Server

Eureka is a service discovery tool from the Netflix OSS suite that is commonly used with Spring Cloud. In a
microservices architecture, it helps manage service instances and their locations. This is especially useful when
services need to dynamically scale up or down and their IP addresses and ports change frequently.

### Key Components

1. **Eureka Server**: This is the service registry where microservices register themselves and discover other services.
2. **Eureka Client**: This is the microservice that registers itself with the Eureka server and also fetches the
   registry information to find other services.

### Setting Up Eureka Server

#### Step 1: Add Dependencies

Add the required dependencies to your `pom.xml` for the Eureka server.

```xml

<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Cloud Starter Netflix Eureka Server -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>

    <!-- Spring Boot Starter Actuator (optional for monitoring) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>

    <!-- Spring Cloud Dependencies -->
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>2021.0.4</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
</dependencies>
```

#### Step 2: Create the Eureka Server Application

Create a Spring Boot application and enable Eureka Server by annotating the main application class
with `@EnableEurekaServer`.

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
```

#### Step 3: Configure Eureka Server

Add the necessary configuration to your `application.properties` or `application.yml` file.

```properties
# application.properties
server.port=8761
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
spring.application.name=eureka-server
```

```yaml
# application.yml
server:
  port: 8761

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false

spring:
  application:
    name: eureka-server
```

### Setting Up Eureka Clients

#### Step 1: Add Dependencies

Add the Eureka client dependencies to your `pom.xml`.

```xml

<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Cloud Starter Netflix Eureka Client -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>

    <!-- Spring Boot Starter Actuator (optional for monitoring) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>

    <!-- Spring Cloud Dependencies -->
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>2021.0.4</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
</dependencies>
```

#### Step 2: Enable Eureka Client

Annotate your main application class with `@EnableEurekaClient`.

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }
}
```

#### Step 3: Configure Eureka Client

Add the necessary configuration to your `application.properties` or `application.yml` file.

```properties
# application.properties
spring.application.name=my-service
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
eureka.instance.prefer-ip-address=true
```

```yaml
# application.yml
spring:
  application:
    name: my-service

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
  instance:
    prefer-ip-address: true
```

### Service Discovery with Eureka

Once both the Eureka server and clients are set up, the clients will automatically register themselves with the Eureka
server and can discover each other using the service names.

#### Example: Using RestTemplate for Service Discovery

You can use `RestTemplate` or `Feign` to call other services registered with Eureka.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/call-other-service/{id}")
    public String callOtherService(@PathVariable("id") Long id) {
        String otherServiceUrl = "http://other-service/api/data/" + id;
        return restTemplate.getForObject(otherServiceUrl, String.class);
    }
}
```

### Summary

1. **Eureka Server**: Set up an Eureka server that acts as a service registry.
2. **Eureka Clients**: Microservices register themselves with the Eureka server and can discover other services
   registered with it.
3. **Service Discovery**: Use service discovery to call other services without hardcoding their URLs, making your
   architecture more dynamic and scalable.

By integrating Eureka into your Spring Boot applications, you can build resilient and scalable microservices
architectures with dynamic service discovery and registration.