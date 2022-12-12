# Summary of the practice

Thinking about the next steps after your current project, we believe that it would be very interesting for you to be able to access an Inditex project. Specifically, we have thought about the current Fulfillment team that is in charge of sending the preparation orders to the centers.

To do this, Inditex asks us for a technical test and then an interview with them.

The test is attached and as general indications I would tell you that they like an API First approach, hexagonal architecture (maximum decoupling), cover most of the test pyramid, follow good practices (Clean Code, SOLID...), as well as containerize the solutions.

It is essential to include a README (in English) in which design decisions, compilation commands, startup, etc. are indicated, as well as the main URLs of the application (swagger, openapi, H2 console, postman with test requests, etc. ...). In the end it is for them to see your potential so the better you display it the more they will appreciate it.

When you have it ready, share it with me, please. The best thing would be a zip inside google drive, if you also have it in a repo, even better because they can see commits and so on.

Of course, if you have any questions, let me know and we'll see. Normally it usually takes a couple of days if it is full dedication or a week if it is partial.


[link text](postman/alex-exercise.postman_collection.json)


# Exercise

In the company's e-commerce database we have the PRICES table that reflects the final price (pvp) and the rate that applies to a product from 
a chain between certain dates. Below is an example of the table with the relevant fields:

PRICES
-------

| BRAND_ID | START_DATE | END_DATE | PRICE_LIST | PRODUCT_ID | PRIORITY | PRICE | CURR |
|----------|------------|----------|------------|------------|----------|-------|------|
| 1 | 2020-06-14 00:00:00 | 2020-12-31 23:59:59 | 1 | 35455 | 0 | 35.50 | EUR |
| 1 | 2020-06-14 15:00:00 | 2020-06-14 18:30:00 | 2 | 35455 | 1 | 25.45 | EUR |
| 1 | 2020-06-15 00:00:00 | 2020-06-15 11:00:00 | 3 | 35455 | 1 | 30.50 | EUR |
| 1 | 2020-06-15 16:00:00 | 2020-12-31 23:59:59 | 4 | 35455 | 1 | 38.95 | EUR |
 
## Campos

| Nombre | Descripcion |
|--------|-------------|
| BRAND_ID | foreign key of the group string (1 = ZARA). |
| START_DATE,END_DATE | range of dates in which the indicated price rate applies. |
| PRICE_LIST | Applicable price rate identifier. |
| PRODUCT_ID | Product code identifier. |
| PRIORITY | Price application disambiguator. If two rates coincide in a range of dates, the one with the highest priority (highest numerical value) is applied. |
| PRICE | final sale price. |
| CURR | iso of currency |
 
## caso de uso

It is requested:

Build an application/service in SpringBoot that provides a query rest endpoint such that:

Accept as input parameters: application date, product identifier, string identifier.
Return as output data: product identifier, string identifier, rate to apply, application dates and final price to apply.

You must use an in-memory database (h2 type) and initialize with the data from the example, (you can change the name of the fields and add new ones if you want, choose the type of data that is considered appropriate for them ).

Develop some tests to the rest endpoint that validate the following requests to the service with the data from the example:

- Test 1: request at 10:00 on day 14 of product 35455 for brand 1 (ZARA)
- Test 2: request at 4:00 p.m. on day 14 of product 35455 for brand 1 (ZARA)
- Test 3: request at 9:00 p.m. on day 14 of product 35455 for brand 1 (ZARA)
- Test 4: request at 10:00 on day 15 of product 35455 for brand 1 (ZARA)
- Test 5: request at 9:00 p.m. on the 16th of product 35455 for brand 1 (ZARA)


# postman
[alex-exercise.postman_collection.json](postman%2Falex-exercise.postman_collection.json)

# specs
[openapi.yaml](specs%2Fopenapi.yaml)


###  Build and Run application
[]()
_GOTO >_ **~/absolute-path-to-directory/alex-exercise**  
and try below command in terminal
> **```mvn spring-boot:run```** it will run application as spring boot application


or
> **```mvn clean install```** it will build application and create **jar** file under target directory

Run jar file from below path with given command
> **```java -jar ~/path-to-alex-exercise/target/alex-exercise-0.0.1-SNAPSHOT.jar```**



 
