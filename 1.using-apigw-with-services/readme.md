# Using Spring Cloud APIGW

- Eureka: http://localhost:8010/

<img width="1509" alt="Screenshot 2022-07-06 at 11 54 16 AM" src="https://user-images.githubusercontent.com/54174687/177482982-e0f4b5cb-088f-48b2-b244-87857f110839.png">

# api-gw

application.properties

```properties

server.port=8082
spring.application.name=api-gateway
eureka.client.serviceUrl.defaultZone=http://localhost:8010/eureka

spring.cloud.gateway.discovery.locator.enabled=true
spring.cloud.gateway.discovery.locator.lower-case-service-id=true

spring.cloud.gateway.routes[0].id=users-status-check
spring.cloud.gateway.routes[0].uri=lb://users-ws
spring.cloud.gateway.routes[0].predicates[0]=Path=/users/status/check
spring.cloud.gateway.routes[0].predicates[1]=Method=GET
spring.cloud.gateway.routes[0].filters[0]=RemoveRequestHeader=Cookie

# This is strict match - must need to pass "/users-ws/users/status/check" from POSTMAN
#spring.cloud.gateway.routes[0].filters[1]=RewritePath=/users-ws/users/status/check,/users/status/check
#spring.cloud.gateway.routes[0].filters[1]=RewritePath=/users-ws/(?<segment>.*), /$\{segment}
```
- Here the cache is because of discovery location feature enable - its automatically understnding with and without `users-ws`.   

GET -> `http://localhost:8082/users-ws/users/status/check`

<img width="900" alt="Screenshot 2022-07-06 at 11 55 01 AM" src="https://user-images.githubusercontent.com/54174687/177483086-f35f9d40-d03b-4f6d-8212-954eb1f0ca57.png">

GET -> `http://localhost:8082/users/status/check`

<img width="903" alt="Screenshot 2022-07-06 at 11 55 42 AM" src="https://user-images.githubusercontent.com/54174687/177483190-f478d125-f84d-4c0b-a832-e12dda3a539d.png">




