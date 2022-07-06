# APIGW With Microservices, Security and H2 DB

- Eureka: http://localhost:8010/

<img width="1512" alt="Screenshot 2022-07-06 at 2 31 05 PM" src="https://user-images.githubusercontent.com/54174687/177512910-16d2c709-ac51-4216-a199-00a997e4573d.png">

GET ->

```json
curl --location --request POST 'http://localhost:8011/users-ws/users' \
--header 'Accept: application/xml' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "Prateek",
    "lastName": "Ashtikar",
    "password": "12345678",
    "email": "prateek.ashtikar@gmail.com"
}'
```

<img width="901" alt="Screenshot 2022-07-06 at 2 34 26 PM" src="https://user-images.githubusercontent.com/54174687/177513470-5d2c264d-83e2-4571-8453-04d058b9cf8e.png">

GET -> 

```json
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
<img width="898" alt="Screenshot 2022-07-06 at 2 35 50 PM" src="https://user-images.githubusercontent.com/54174687/177513734-015fd068-21dc-42c0-b333-2ab6231c527b.png">

<img width="1367" alt="Screenshot 2022-07-06 at 2 36 22 PM" src="https://user-images.githubusercontent.com/54174687/177513838-d748ed1f-3180-4abc-9b39-13f2f0c85ba5.png">

<img width="1260" alt="Screenshot 2022-07-06 at 2 37 33 PM" src="https://user-images.githubusercontent.com/54174687/177514162-b7a1cc29-5fcc-4140-ade5-d5c93072f979.png">


