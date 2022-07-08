# Circuit Breaker In Microservices

application.properties

```properties
server.port=${PORT:0}
spring.application.name=users-ws

eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
eureka.client.serviceUrl.defaultZone=http://localhost:8010/eureka

spring.devtools.restart.enabled=true
eureka.instance.instance-id=${spring.application.name}:${spring.application.instance_id:${random.value}}

# H2 DB
spring.h2.console.enabled=true
spring.h2.console.settings.web-allow-others=true
spring.datasource.generate-unique-name=false

#spring.datasource.url=jdbc:h2:mem:testdb
#spring.datasource.driverClassName=org.h2.Driver  
#spring.datasource.username=sa  
#spring.datasource.password=  
#spring.jpa.database-platform=org.hibernate.dialect.H2Dialect  

#gateway.ip=192.168.100.42
#token.expiration_time = 864000000
#token.secret = hfgry463hf746hf573ydh475fhy5739
#login.url.path = /users/login

spring.config.import=configserver:http://localhost:8012/

# RabbitMQ Details
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest

management.endpoint.health.enabled=true
management.endpoint.health.show-details=always
management.endpoint.circuitbreakers.enabled=true

# Actuator
management.endpoints.web.exposure.include=*

# Resilience4J
resilience4j.circuitbreaker.instances.albums-ws.failure-rate-threshold=50
resilience4j.circuitbreaker.instances.albums-ws.automatic-transition-from-open-to-half-open-enabled=true
resilience4j.circuitbreaker.instances.albums-ws.wait-duration-in-open-state=10000ms
resilience4j.circuitbreaker.instances.albums-ws.sliding-window-type=COUNT_BASED
resilience4j.circuitbreaker.instances.albums-ws.sliding-window-size=2
resilience4j.circuitbreaker.instances.albums-ws.minimum-number-of-calls=10
resilience4j.circuitbreaker.instances.albums-ws.event-consumer-buffer-size=10

logging.level.com.example.client.AlbumsServiceClient=DEBUG
albums.exceptions.albums-not-found=Users Albums are not found !!
```

Eureka: http://localhost:8010/

<img width="1510" alt="Screenshot 2022-07-08 at 5 58 01 PM" src="https://user-images.githubusercontent.com/54174687/178042866-c4d47387-149c-457c-b9ee-827783d21677.png">

- Create the user if not already created !

<img width="1270" alt="Screenshot 2022-07-08 at 6 00 07 PM" src="https://user-images.githubusercontent.com/54174687/178043045-8bcccfca-7aa0-4dad-a99b-efee18097ea0.png">

<img width="1269" alt="Screenshot 2022-07-08 at 6 00 57 PM" src="https://user-images.githubusercontent.com/54174687/178043062-d1fb0ec5-6606-41ce-8671-60b7d5d57e43.png">

<img width="1270" alt="Screenshot 2022-07-08 at 6 06 28 PM" src="https://user-images.githubusercontent.com/54174687/178043217-a5b9f15d-2be3-476e-86da-5c6877dda106.png">

- Stop the `albums-service` and hit the below

<img width="1270" alt="Screenshot 2022-07-08 at 6 06 28 PM" src="https://user-images.githubusercontent.com/54174687/178043290-f2139ad7-022d-4a03-b50b-79941ced81fa.png">

- Again start the `albums-service` and hit the above

GET -> `curl --location --request GET 'http://localhost:8011/users-ws/actuator/circuitbreakerevents'`

Response:-

```json
{
    "circuitBreakerEvents": [
        {
            "circuitBreakerName": "albums-ws",
            "type": "SUCCESS",
            "creationTime": "2022-07-08T21:52:24.486411+05:30[Asia/Kolkata]",
            "errorMessage": null,
            "durationInMs": 348,
            "stateTransition": null
        },
        {
            "circuitBreakerName": "albums-ws",
            "type": "ERROR",
            "creationTime": "2022-07-08T21:55:44.768869+05:30[Asia/Kolkata]",
            "errorMessage": "feign.RetryableException: Connection refused (Connection refused) executing GET http://albums-ws/users/0a55a956-130a-4f23-828e-5f450f6af75c/albums",
            "durationInMs": 18,
            "stateTransition": null
        },
        {
            "circuitBreakerName": "albums-ws",
            "type": "FAILURE_RATE_EXCEEDED",
            "creationTime": "2022-07-08T21:55:44.770462+05:30[Asia/Kolkata]",
            "errorMessage": null,
            "durationInMs": null,
            "stateTransition": null
        },
        {
            "circuitBreakerName": "albums-ws",
            "type": "STATE_TRANSITION",
            "creationTime": "2022-07-08T21:55:44.773024+05:30[Asia/Kolkata]",
            "errorMessage": null,
            "durationInMs": null,
            "stateTransition": "CLOSED_TO_OPEN"
        },
        {
            "circuitBreakerName": "albums-ws",
            "type": "STATE_TRANSITION",
            "creationTime": "2022-07-08T21:55:54.781042+05:30[Asia/Kolkata]",
            "errorMessage": null,
            "durationInMs": null,
            "stateTransition": "OPEN_TO_HALF_OPEN"
        },
        {
            "circuitBreakerName": "albums-ws",
            "type": "SUCCESS",
            "creationTime": "2022-07-08T21:58:20.178956+05:30[Asia/Kolkata]",
            "errorMessage": null,
            "durationInMs": 191,
            "stateTransition": null
        }
    ]
}
```
