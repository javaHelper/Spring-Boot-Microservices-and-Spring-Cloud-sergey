# Asymetric Encryption using JKS and JCE

POST ->

```sh
curl --location --request POST 'http://localhost:8012/encrypt' \
--header 'Content-Type: text/plain' \
--data-raw 'Prateek'
``
<img width="1270" alt="Screenshot 2022-07-08 at 1 57 53 PM" src="https://user-images.githubusercontent.com/54174687/177951055-5a7cd029-61a1-4334-84aa-507f2aa5820a.png">


POST ->

```sh
curl --location --request POST 'http://localhost:8012/decrypt' \
--header 'Content-Type: text/plain' \
--data-raw 'AQBa6pyuoZgWM80JbDw95olsBFk84C+Lpc1uJvLZostQBXS8ElZowmLAaRjVLsN0nEdoWUKvRlxWYg9SO06C/lZHknzC/Ll/nSqmVVTiTYAi+K7jHzFdKtiIZAyQ39cLn1ql2zGVfE0nkI6K3H/R5BE8PooHmkHUq9iJrZRgMBO7koFQxiq5/ZBRexwUSLu0qfwa5T2GUhrMAtMYRMIUf+fstMrQ/jpYnR4CWjH5dWWZypH8geNSjrPiC6UM8PD++CrGhjkGl5/I4EIt+x50v0FH9EBl5Qo/r3RFYRBuNkVtPCOKp4vaT/qr6oMl3NRIoZoCjcJ1R+XPc0x/rhJdH0ZmQYHAXOYZeElHGOdJdpba7oElIC2swTw8jI0qROnKQZ0='
```
<img width="1270" alt="Screenshot 2022-07-08 at 1 58 45 PM" src="https://user-images.githubusercontent.com/54174687/177951114-1a19ddc5-e90d-4f2b-add2-e73e304ddba8.png">

GET -> 

```sh
curl --location --request GET 'http://localhost:8012/users-ws/default'
```

<img width="1252" alt="Screenshot 2022-07-08 at 1 59 39 PM" src="https://user-images.githubusercontent.com/54174687/177951347-19f2cef1-2ac3-4580-bf89-a04a876a2516.png">

