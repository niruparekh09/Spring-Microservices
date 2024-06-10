## Feign
Feign is a declarative web service client provided by Spring Cloud that simplifies making HTTP requests to other
microservices. With Feign, you can create a proxy to interact with other services by defining an interface and
annotating it. This makes calling other microservices as simple as calling a method.

Here's how you can use Feign to set up a proxy and retrieve information from another microservice in Spring Boot:

### Step-by-Step Guide

#### Step 1: Add Dependencies

First, you need to add the necessary dependencies for Feign and Spring Cloud to your `pom.xml`:

```xml

<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Cloud Starter OpenFeign -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-openfeign</artifactId>
    </dependency>

    <!-- Spring Boot Starter Actuator (optional for monitoring) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>

    <!-- Spring Cloud Dependencies (replace version with the latest stable version) -->
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

#### Step 2: Enable Feign Clients

Enable Feign clients in your Spring Boot application by annotating your main application class
with `@EnableFeignClients`.

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

#### Step 3: Define a Feign Client Interface

Create an interface that will serve as a proxy to the other microservice. Use the `@FeignClient` annotation to specify
the name of the service and the base URL.

```java
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

// Replace "other-service" with the name of the other microservice
@FeignClient(name = "other-service", url = "http://localhost:8081")
public interface OtherServiceClient {

    // Define methods that correspond to the API endpoints of the other service
    @GetMapping("/api/data/{id}")
    DataResponse getDataById(@PathVariable("id") Long id);

    @GetMapping("/api/data")
    List<DataResponse> getDataByParam(@RequestParam("param") String param);
}
```

#### Step 4: Use the Feign Client in Your Service

Autowire the Feign client into a service or controller to use it for making requests to the other microservice.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    private OtherServiceClient otherServiceClient;

    public DataResponse fetchDataById(Long id) {
        return otherServiceClient.getDataById(id);
    }

    public List<DataResponse> fetchDataByParam(String param) {
        return otherServiceClient.getDataByParam(param);
    }
}
```

#### Step 5: Create a Controller to Expose an Endpoint

Create a controller to expose an endpoint in your service that uses the Feign client to fetch data from the other
service.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/mydata/{id}")
    public DataResponse getDataById(@PathVariable("id") Long id) {
        return myService.fetchDataById(id);
    }

    @GetMapping("/mydata")
    public List<DataResponse> getDataByParam(@RequestParam("param") String param) {
        return myService.fetchDataByParam(param);
    }
}
```

#### Step 6: Define DataResponse Class

Create a class to represent the response data structure from the other microservice.

```java
public class DataResponse {
    private Long id;
    private String data;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
```

### Summary

1. **Add Dependencies**: Include Feign and Spring Cloud dependencies in your `pom.xml`.
2. **Enable Feign Clients**: Annotate your main application class with `@EnableFeignClients`.
3. **Define Feign Client Interface**: Create an interface annotated with `@FeignClient` to define the endpoints you want
   to call on the other microservice.
4. **Use Feign Client**: Autowire the Feign client into a service or controller to make HTTP requests to the other
   microservice.
5. **Expose an Endpoint**: Create a controller to expose an endpoint that uses the Feign client.

By following these steps, you can easily set up a Feign client in your Spring Boot application to communicate with other
microservices, making your application more modular and easier to manage.