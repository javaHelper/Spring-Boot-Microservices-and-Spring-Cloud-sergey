# Interservice communication using RestTemplate 

Eureka: http://localhost:8010/

<img width="1510" alt="Screenshot 2022-07-08 at 5 58 01 PM" src="https://user-images.githubusercontent.com/54174687/177992154-88accd6e-566d-4220-aea0-d14b4fe3e569.png">

# Create User 

```sh
curl --location --request POST 'http://localhost:8011/users-ws/users' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "Prateek1",
    "lastName": "Ashtikar1",
    "password": "12345678",
    "email": "prateek.ashtikar1@gmail.com"
}'
```
<img width="1270" alt="Screenshot 2022-07-08 at 6 00 07 PM" src="https://user-images.githubusercontent.com/54174687/177992493-3396ccc2-d3ce-4648-a69b-581d7136a17d.png">

# Login the User and Generate JWT

```sh
curl --location --request POST 'http://localhost:8011/users-ws/users/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "prateek.ashtikar1@gmail.com",
    "password" : "12345678"
}'
```
<img width="1269" alt="Screenshot 2022-07-08 at 6 00 57 PM" src="https://user-images.githubusercontent.com/54174687/177992819-b61a091b-dd37-44f3-b0ba-83b2cbf27fc5.png">

Copy UserId: 0a55a956-130a-4f23-828e-5f450f6af75c and use this UserId to make the pass 

```sh
curl --location --request GET 'http://localhost:8011/users-ws/users/0a55a956-130a-4f23-828e-5f450f6af75c' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIwYTU1YTk1Ni0xMzBhLTRmMjMtODI4ZS01ZjQ1MGY2YWY3NWMiLCJleHAiOjE2NTgxNDY2NjF9.4TyVDXboPnGjDU761ZyVwl0x9v8NqgMgHUwEPeqcL7ZQJSVjDAqJzfFpNASInL-US5d2RYn5dJlVRCdbVwBgJQ' \
--header 'Accept: application/json'
```

<img width="1270" alt="Screenshot 2022-07-08 at 6 06 28 PM" src="https://user-images.githubusercontent.com/54174687/177993402-9d541bf3-9db3-43b0-a7fe-19b2ac063af6.png">


