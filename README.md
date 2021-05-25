"# reward-program-service" 

###To get the reward point:

(POST) localhost:8080/transaction/ 
```aidl
{
"customerId":1,
"year":"2021",
"month":"5"
}
```
###To get all transaction by a customer id

(GET) localhost:8080/transaction/customer/1
```aidl
No request body
```

###To add a transaction for particular customer id
(POST) localhost:8080/transaction/customer
```aidl
{
"customerId": 1,
"amount": 100.00,
"purchaseDate": "2021-04-01"
}
```
