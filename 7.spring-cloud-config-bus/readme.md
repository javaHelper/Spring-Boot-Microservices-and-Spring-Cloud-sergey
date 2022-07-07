# Spring Cloud Config Bus

# Sequence to start microservices

- discovery-service
- config-service
- photo-service
- api-gateway

Eureka: http://localhost:8010/

<img width="1507" alt="Screenshot 2022-07-07 at 5 23 59 PM" src="https://user-images.githubusercontent.com/54174687/177767209-44da3cda-1b71-4337-a3f7-6372913d5e88.png">

Add below in config-service

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

<!-- Added -->
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>
```

add below in application.properties

```properties
management.endpoints.web.exposure.include=busrefresh
```

POST -> 

```sh
curl --location --request POST 'http://localhost:8011/users-ws/users' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "Prateek",
    "lastName": "Ashtikar",
    "password": "12345678",
    "email": "prateek.ashtikar@gmail.com"
}'
```

<img width="1288" alt="Screenshot 2022-07-07 at 5 27 04 PM" src="https://user-images.githubusercontent.com/54174687/177767729-a0351654-149c-4c86-9085-99c0f909b229.png">

Once user is created execute below

POST ->

```sh
curl --location --request POST 'http://localhost:8011/users-ws/users/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "prateek.ashtikar@gmail.com",
    "password" : "12345678"
}'
```
<img width="1245" alt="Screenshot 2022-07-07 at 5 28 02 PM" src="https://user-images.githubusercontent.com/54174687/177767891-92043e94-52d6-4e33-9813-4e7934f4bda6.png">

Use that token to hit the endpoint 

```sh
curl --location --request GET 'http://localhost:8011/users-ws/users/status/check' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI2M2ZjNzAxMC1jMDA5LTRiNmQtOTM1OS0zZWJjZDFiZTM1ZTkiLCJleHAiOjE2NTgwNTg0ODN9.qzMA4l606O1NXoXA5YZGVWeNfR79l66BPq7llAFFvoWaF9aJ5vV4MeItpHLxRej8vHVID4Q-MULBLn2VBTsSvA'
```

<img width="1273" alt="Screenshot 2022-07-07 at 5 30 02 PM" src="https://user-images.githubusercontent.com/54174687/177768257-5687b945-4274-4f73-a2c1-33f2ce95a84b.png">

Now change the token.secrete value adding dummy number at the end 111.

POST -> `http://localhost:8012/actuator/busrefresh`

<img width="1238" alt="Screenshot 2022-07-07 at 5 31 47 PM" src="https://user-images.githubusercontent.com/54174687/177768530-ede40cf5-3a01-4229-8757-bde50cbe9a6a.png">

now make the sure to hit POST request to login user - get new jwt token.









