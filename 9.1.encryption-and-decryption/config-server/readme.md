# Encryption and Decryption

POST -> 

```sh
curl --location --request POST 'http://localhost:8012/encrypt' \
--header 'Content-Type: text/plain' \
--data-raw 'Prateek'
```

<img width="1249" alt="Screenshot 2022-07-08 at 11 10 46 AM" src="https://user-images.githubusercontent.com/54174687/177924518-a667e665-7a2e-47e5-88da-6453ecac4076.png">

POST ->

```sh
curl --location --request POST 'http://localhost:8012/decrypt' \
--header 'Content-Type: text/plain' \
--data-raw '7bcc2960156225005e39871b1c35b7742d670d25cac9e69bc9380bd22607aaa6'
```

<img width="1268" alt="Screenshot 2022-07-08 at 11 11 43 AM" src="https://user-images.githubusercontent.com/54174687/177924642-7a336f84-08bb-4171-9cfc-e901ff31c972.png">

GET -> `curl --location --request GET 'http://localhost:8012/users-ws/default'`

<img width="1240" alt="Screenshot 2022-07-08 at 11 12 43 AM" src="https://user-images.githubusercontent.com/54174687/177924790-b1dd3bd5-4bad-4b8c-8910-e5f3af18070f.png">


