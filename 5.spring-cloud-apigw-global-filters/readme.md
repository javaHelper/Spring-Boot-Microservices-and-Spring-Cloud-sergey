# Spring Cloud APIGW with Global Filters

Eureka: http://localhost:8010/

POST -> 

```sh
curl --location --request POST 'http://localhost:8011/users-ws/users' \
--header 'Accept: application/json' \
--header 'Authorization: Bearer ABC' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "Prateek",
    "lastName": "Ashtikar",
    "password": "12345678",
    "email": "prateek.ashtikar@gmail.com"
}'
```

<img width="1270" alt="Screenshot 2022-07-07 at 11 46 48 AM" src="https://user-images.githubusercontent.com/54174687/177704712-2124c962-7c1d-4203-a6ff-3ee1f94d0512.png">


<img width="1366" alt="Screenshot 2022-07-07 at 11 45 48 AM" src="https://user-images.githubusercontent.com/54174687/177704621-051db33d-8048-4de3-9d4f-1b6adacc6707.png">
