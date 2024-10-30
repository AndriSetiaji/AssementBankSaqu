# AssementBankSaqu
### tech stack:
- Language: Java 17 ✔️
- Framework: Springboot ✔️
- Logging: slf4j ✔️
- Database: PostgreSQL (optional) ✔️
- Message Broker: RabbitMQ (optional) ✔️

## ERD on PostgresSql
![image](https://github.com/user-attachments/assets/f1cd2154-aa22-43e3-a461-00cfd35dd253)

## API post create account - POST /accounts
```
curl --location 'http://192.168.1.9:8080/accounts' \
--header 'Content-Type: application/json' \
--data-raw '{
    "fullName": "test7",
    "email": "test7@gmail.com"
}'
```
postman :
![image](https://github.com/user-attachments/assets/54bb24c6-a7f4-4591-b737-25ffe4451c6d)
account :
![image](https://github.com/user-attachments/assets/2af6361f-c103-450a-9d27-bb3de54c50e3)
balance :
![image](https://github.com/user-attachments/assets/f4d03150-d517-429a-b943-65c773532fee)



## API post deposit - POST /transactions/deposit
```
curl --location 'http://192.168.1.9:8080/transactions/deposit' \
--header 'Content-Type: application/json' \
--data '{
    "accountId": 9,
    "amount": 1000
}'
```
postman :
![image](https://github.com/user-attachments/assets/d36d0c18-18e4-46d5-bf65-524c24654622)
transaction :
![image](https://github.com/user-attachments/assets/f114920d-ab36-485c-93d3-f4a7fe0d60b6)
balance :
![image](https://github.com/user-attachments/assets/9b2fd0f2-613e-4eb8-97bf-4646497680ab)
logging :
![image](https://github.com/user-attachments/assets/3da1ae13-bf12-4231-a543-cde6c36c12e1)
rabbitmq :
![image](https://github.com/user-attachments/assets/0de9ae13-9101-4082-b8dd-8c61865c30d4)

## API post withdraw - POST /transactions/withdraw
```
curl --location 'http://192.168.1.9:8080/transactions/withdraw' \
--header 'Content-Type: application/json' \
--data '{
    "accountId": 9,
    "amount": 10
}'
```
postman :
![image](https://github.com/user-attachments/assets/2f0d8e95-a026-4ee3-a76b-4e7dda36709c)
transaction :
![image](https://github.com/user-attachments/assets/f9baa68f-0da3-49e4-a2d4-696207458823)
balance :
![image](https://github.com/user-attachments/assets/266ea8cd-fe87-4ddc-b66a-3f1c9b1ffec4)

## API post transfer - POST /transactions/transfer
```
curl --location 'http://localhost:8080/transactions/transfer' \
--header 'Content-Type: application/json' \
--data '{
    "accountId": 9,
    "destinationAccountId": 4,
    "amount": 200
}'
```
postman :
![image](https://github.com/user-attachments/assets/5f661d49-8485-4f6b-849c-bc64aff6ab68)
transaction :
![image](https://github.com/user-attachments/assets/53e3dbea-050e-49db-90d9-d1a8b010a065)
balance :
![image](https://github.com/user-attachments/assets/3b6bab26-48e4-457b-8154-915a4d47f2cc)


