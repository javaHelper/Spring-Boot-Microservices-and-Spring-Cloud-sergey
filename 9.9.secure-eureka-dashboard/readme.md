# Secure Eureka Dashboard:

Eureka: http://localhost:8010/
username/password = test/test

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
<img width="1238" alt="Screenshot 2022-07-11 at 2 52 22 PM" src="https://user-images.githubusercontent.com/54174687/178232459-2f1da584-2120-4967-b787-5e7fff72d9e4.png">

POST ->

```sh
curl --location --request GET 'http://localhost:8011/users-ws/users/0a55a956-130a-4f23-828e-5f450f6af75c' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIwYTU1YTk1Ni0xMzBhLTRmMjMtODI4ZS01ZjQ1MGY2YWY3NWMiLCJleHAiOjE2NTgzOTUxNTJ9.HUzzx0VlGeKGRuAuS1H4p_lOzPtJRMhIhD74TPLvjh6g7q-3Ih8jwNgcH_QOBuaNjShyTrJMxreZDlr4clHqoQ' \
--header 'Accept: application/json'
```

<img width="1241" alt="Screenshot 2022-07-11 at 2 53 19 PM" src="https://user-images.githubusercontent.com/54174687/178232681-a0e50a12-1f49-4140-b4f2-ec11ac017b58.png">

