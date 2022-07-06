# Spring Security Login

Eureka: http://localhost:8010/

<img width="1508" alt="Screenshot 2022-07-06 at 5 54 22 PM" src="https://user-images.githubusercontent.com/54174687/177549490-2ba57240-37e7-4aab-86c3-7c1a3b757b17.png">

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
<img width="849" alt="Screenshot 2022-07-06 at 5 56 19 PM" src="https://user-images.githubusercontent.com/54174687/177549806-98cae503-339c-4f32-b188-7ac6d625d701.png">

POST -> 

```sh
curl --location --request POST 'http://localhost:8011/users-ws/users/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "prateek.ashtikar@gmail.com",
    "password" : "12345678"
}'
```
<img width="1243" alt="Screenshot 2022-07-06 at 5 57 49 PM" src="https://user-images.githubusercontent.com/54174687/177550050-c0d589ac-ca6c-48c6-9dad-3aab44a2eaa7.png">

Use the IP of `photo-service`

<img width="1212" alt="Screenshot 2022-07-06 at 5 59 43 PM" src="https://user-images.githubusercontent.com/54174687/177550375-a8989062-f360-41db-80bf-5f44cd9023d9.png">

Sample JWT token

```sh
eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI4MjFlZjE4OS04ZTBhLTQwMGUtODI1My04Y2RjZjFiMTVmOTgiLCJleHAiOjE2NTc5NzM3MjB9.4Evn4_w8-FDMlGO_gD7Qp96wiVMRzDqsyJIn3iKZ0MZKjopNggN6O42Pr0PuodaH_mfsjsxbDSklJ3PtyWKpnw
```
