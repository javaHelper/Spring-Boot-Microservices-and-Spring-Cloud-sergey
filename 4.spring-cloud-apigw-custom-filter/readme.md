# Spring Cloud APIGW

Eureka: http://localhost:8010/

POST -> 

```sh
curl --location --request POST 'http://localhost:8011/users-ws/users' \
--header 'Authorization: Bearer ABC' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "Prateek",
    "lastName": "Ashtikar",
    "password": "12345678",
    "email": "prateek.ashtikar@gmail.com"
}'
```
<img width="1269" alt="Screenshot 2022-07-06 at 10 01 49 PM" src="https://user-images.githubusercontent.com/54174687/177599605-a58e0551-aa45-430c-8a0e-5bde0f5f6580.png">


POST -> 

```sh
curl --location --request POST 'http://localhost:8011/users-ws/users/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "prateek.ashtikar@gmail.com",
    "password" : "12345678"
}'
```
<img width="1269" alt="Screenshot 2022-07-06 at 10 03 22 PM" src="https://user-images.githubusercontent.com/54174687/177599959-fdc8d41c-a854-4ef6-90d0-a98755bd34b7.png">

JWT -> `eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI1NjM3YjEwNi0yZDYxLTQwMTgtOTAwMi1jMmRlOTlmY2YyZjkiLCJleHAiOjE2NTc5ODg0OTd9.cpx18jTFGIjlsX4JzgUJZdukqxvLU7G_jd7XR6sxIYG2IlfH35nKuG_KACeIO7MIyCr6bPgXWXvC6jQZc6ek0A`

GET ->

```sh
curl --location --request GET 'http://localhost:8011/users-ws/users/status/check' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI1NjM3YjEwNi0yZDYxLTQwMTgtOTAwMi1jMmRlOTlmY2YyZjkiLCJleHAiOjE2NTc5ODg0OTd9.cpx18jTFGIjlsX4JzgUJZdukqxvLU7G_jd7XR6sxIYG2IlfH35nKuG_KACeIO7MIyCr6bPgXWXvC6jQZc6ek0A'
```
<img width="1272" alt="Screenshot 2022-07-06 at 10 20 26 PM" src="https://user-images.githubusercontent.com/54174687/177602801-c435cb7a-5942-4ed9-a655-4209ffda9d0a.png">

