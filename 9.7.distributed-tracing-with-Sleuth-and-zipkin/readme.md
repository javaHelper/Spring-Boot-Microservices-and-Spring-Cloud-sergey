# Distributed Tracing with Sleuth and Zipkin

- Eureka: http://localhost:8010/

<img width="1503" alt="Screenshot 2022-07-09 at 8 55 01 PM" src="https://user-images.githubusercontent.com/54174687/178112068-c237edb3-ea32-4bfc-a0fd-ef4deda92060.png">

<img width="1395" alt="Screenshot 2022-07-09 at 8 55 39 PM" src="https://user-images.githubusercontent.com/54174687/178112095-2f77ef5a-1da1-410f-8b58-7b8c5f10308a.png">

POST -> 

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

POST -> 

```sh
curl --location --request POST 'http://localhost:8011/users-ws/users/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "prateek.ashtikar1@gmail.com",
    "password" : "12345678"
}'
```

GET -> 

```sh
curl --location --request GET 'http://localhost:8011/users-ws/users/0a55a956-130a-4f23-828e-5f450f6af75c' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIwYTU1YTk1Ni0xMzBhLTRmMjMtODI4ZS01ZjQ1MGY2YWY3NWMiLCJleHAiOjE2NTgyNDEzMDN9.gmLlrUsVQ_nYeUzhxvzbxY_SucwaaaNwIXA9lxWzk0n1TbFJCC61Gh7T2tVjwxJvwjMBC_ln5wr5SYlKroytCw' \
--header 'Accept: application/json'
```

<img width="1220" alt="Screenshot 2022-07-09 at 8 57 49 PM" src="https://user-images.githubusercontent.com/54174687/178112164-17e44ff9-e382-4a97-8890-e6006757b02f.png">

# Zipkin
http://localhost:9411/

<img width="1495" alt="Screenshot 2022-07-09 at 8 59 03 PM" src="https://user-images.githubusercontent.com/54174687/178112215-362f3651-c1af-4954-8988-0741769c40d0.png">

<img width="1510" alt="Screenshot 2022-07-09 at 8 58 41 PM" src="https://user-images.githubusercontent.com/54174687/178112206-245a91fd-21bd-4b02-852b-90644818d710.png">



