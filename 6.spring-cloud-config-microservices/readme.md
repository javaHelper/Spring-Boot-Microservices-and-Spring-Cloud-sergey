# Spring Cloud Config Server Example 

-  Eureka: http://localhost:8010/

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

<img width="1291" alt="Screenshot 2022-07-07 at 2 22 39 PM" src="https://user-images.githubusercontent.com/54174687/177733283-a863665f-da50-477a-9578-b08c7b3af239.png">

