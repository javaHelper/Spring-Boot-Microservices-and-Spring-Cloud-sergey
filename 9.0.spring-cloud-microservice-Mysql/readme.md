# Spring Boot Microservices using MySQL

Eureka: http://localhost:8010/

<img width="1507" alt="Screenshot 2022-07-07 at 5 23 59 PM" src="https://user-images.githubusercontent.com/54174687/177834112-35045ce0-b7b4-4577-8c5f-3b92b145ce2e.png">

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
<img width="1268" alt="Screenshot 2022-07-07 at 10 58 36 PM" src="https://user-images.githubusercontent.com/54174687/177834277-b2642637-98e5-41ad-a499-18ec7fc9aa24.png">

POST -> 

```sh
curl --location --request POST 'http://localhost:8011/users-ws/users/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "prateek.ashtikar@gmail.com",
    "password" : "12345678"
}'
```
<img width="1272" alt="Screenshot 2022-07-07 at 10 59 16 PM" src="https://user-images.githubusercontent.com/54174687/177834352-a394d3c1-81da-4edd-b88c-58f74de6e21d.png">

GET -> 

```sh
curl --location --request GET 'http://localhost:8011/users-ws/users/status/check' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIzMTkwN2U3Mi04MzMzLTQyNjQtOGIwZi1kZjY0NDI3Y2U4MjMiLCJleHAiOjE2NTgwNzc5NDF9.qxIUJHIERLYLztgg_JB0bA1hqC_H-w9Ymb_ZaITLmxYhij4wzqBlBeY3Kqxn0e9P-l1u5hjlJ4azi3ClqR-Tpw'
```
<img width="1273" alt="Screenshot 2022-07-07 at 10 59 59 PM" src="https://user-images.githubusercontent.com/54174687/177834477-cd2035d6-65e0-4853-af22-5def8adf0a4a.png">

<img width="1045" alt="Screenshot 2022-07-07 at 11 01 26 PM" src="https://user-images.githubusercontent.com/54174687/177834700-70d1658c-3a0c-4f71-bc56-4b24116352d9.png">

